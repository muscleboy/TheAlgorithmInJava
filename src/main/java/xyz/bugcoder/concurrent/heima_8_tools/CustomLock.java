package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: 自定义锁(不可重入)
 * @createTime 2020-11-30 17:27
 */

@Slf4j
public class CustomLock implements Lock {

    // 继承自 AQS，然后重写 tryAcquire, tryRelease, isHeldExclusively
    class MySync extends AbstractQueuedSynchronizer{

        // 获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放锁
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            // setState 要放后面，因为 state 是 volatile 修饰，有写屏障
            setState(0);
            return true;
        }

        // 是否独占
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        protected Condition newCondition(){
            return new ConditionObject();
        }

    }

    private MySync sync = new MySync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition() ;
    }

    public static void main(String[] args) {

        CustomLock lock = new CustomLock();

        new Thread(() -> {
            lock.lock();
            try {
                log.info("t1 lock....");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("t1 unlock....");
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                log.info("t2 lock....");
            }finally {
                log.info("t2 unlock....");
                lock.unlock();
            }
        }, "t2").start();

    }

}
