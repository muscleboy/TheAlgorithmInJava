package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 17:10
 */
@Slf4j
class BlockingQueue<T> {

    // 1.任务队列
    private Deque<T> queue = new ArrayDeque<>();

    // 2.锁
    private ReentrantLock lock = new ReentrantLock();

    // 3.生产者条件
    private Condition producer = lock.newCondition();

    // 4.消费者条件
    private Condition consumer = lock.newCondition();

    // 5.队列容量
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // 6.获取
    public T take(){
        lock.lock();
        try {
            // 空的队列，就阻塞
            while (queue.isEmpty()){
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            producer.signal();
            // 不是空的，从头拿
            return queue.removeFirst();
        }  finally {
            lock.unlock();
        }
    }

    // 带超时阻塞获取
    public T poll(long timeout, TimeUnit unit){
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            // 空的队列，就阻塞
            while (queue.isEmpty()){
                try {
                    if (nanos <= 0){
                        return null;
                    }
                    nanos = consumer.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            producer.signal();
            // 不是空的，从头拿
            return t;
        }  finally {
            lock.unlock();
        }
    }

    // 7.生产
    public void put(T e){
        lock.lock();
        try {
            // 满了，
            while (queue.size() == capacity){
                try {
                    log.info("等待加入任务队列 {}...", e);
                    producer.await();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            log.info("加入任务队列 {}...", e);
            queue.addLast(e);
            consumer.signal();
        }finally {
            lock.unlock();
        }
    }

    // 7.生产带超时时间
    public boolean offer(T task, long timeout, TimeUnit unit){
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            // 满了，
            while (queue.size() == capacity){
                try {
                    if (nanos <= 0){
                        return false;
                    }
                    log.info("等待加入任务队列 {}...", task);
                    nanos = producer.awaitNanos(nanos);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            log.info("加入任务队列 {}...", task);
            queue.addLast(task);
            consumer.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    // 获取容量
    public int size(){
        lock.lock();
        try {
            return queue.size();
        }finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if (queue.size() == capacity){
                rejectPolicy.reject(this, task);
            }else {
                log.info("加入任务队列 {}...", task);
                queue.addLast(task);
                consumer.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}

// 拒绝策略
@FunctionalInterface
interface RejectPolicy<T>{

    void reject(BlockingQueue<T> queue, T task);

}

@Slf4j
class ThreadPool{

    // 自己实现的任务队列
    private BlockingQueue<Runnable> taskQueue;

    // 线程集合，交个它去执行任务
    private HashSet<Worker> workers = new HashSet<>();

    // 大小
    private int coreSize;

    private Runnable task;

    private long timeout;

    private TimeUnit unit;

    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit unit, int queueSize, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.unit = unit;
        this.taskQueue = new BlockingQueue<>(queueSize);
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task){
        synchronized (workers){
            // 任务数 < coreSize，直接执行
            if (workers.size() < coreSize){
                Worker worker = new Worker(task);
                log.info("新增 worker: {}, task: {}", worker, task);
                workers.add(worker);
                worker.start();
            }else {
                // taskQueue.put(task);
                // 队列满了，该执行哪种策略？
                // 1.死等
                // 2.带超时等待
                // 3.让调用者放弃任务执行
                // 4.让调用者抛异常
                // 5.让调用者自己执行任务
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    class Worker extends Thread{

        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            // 执行任务
            // 1.执行当前的 task
            // 2.执行任务队列中的 task
//            while (task != null || (task = taskQueue.take()) != null){

            // 超时时间
            while (task != null || (task = taskQueue.poll(timeout, unit)) != null){
                try {
                    log.info("任务运行.... {}", task);
                    task.run();
                }finally {
                    task = null;
                }
            }

            synchronized (workers){
                log.debug("worker 被移除{}", this);
                workers.remove(this);
            }

        }
    }

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(1, 1, TimeUnit.SECONDS, 1, ((queue, task) -> {
            // 1.死等
//            queue.put(task);
            // 2.带超时等待
//            queue.offer(task, 1500, TimeUnit.MILLISECONDS);
            // 3.让调用者放弃任务执行
//            log.info("放弃 {}...", task);
            // 4.让调用者抛异常
//            throw new RuntimeException("抛异常跳过..." + task);
            // 5.让调用者(main线程)自己执行任务
            task.run();
        }));

        for (int i = 0; i < 3; i++) {
            int j = i;
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("j: {}", j);
            });
        }

    }

}

