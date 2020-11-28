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

    // 7.生产
    public void put(T e){
        lock.lock();
        try {
            // 满了，
            while (queue.size() == capacity){
                try {
                    producer.await();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            queue.addLast(e);
            consumer.signal();
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

    public ThreadPool(int coreSize, long timeout, TimeUnit unit, int queueSize) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.unit = unit;
        this.taskQueue = new BlockingQueue<>(queueSize);
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
                taskQueue.put(task);
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
            while (task != null || (task = taskQueue.take()) != null){
                try {
                    log.info("任务运行.... {}", task);
                    task.run();
                }finally {
                    task = null;
                }
            }

            synchronized (workers){
                log.info("完成 work: {}", workers);
                workers.remove(this);
            }

        }
    }

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(2, 1, TimeUnit.SECONDS, 5);

        for (int i = 0; i < 5; i++) {
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

