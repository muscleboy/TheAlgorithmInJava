package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 20:14
 */

//使用要点：
//        await 前需要获得锁
//        await 执行后，会释放锁，进入 conditionObject 等待
//        await 的线程被唤醒（或打断、或超时）取重新竞争 lock
//        竞争lock 锁成功后，从 await 后继续执行

@Slf4j
public class ReentrantLockCondition {

    static ReentrantLock lock = new ReentrantLock();

    static Condition waitCigaretteQueue = lock.newCondition();
    static Condition waitBreakfastQueue = lock.newCondition();
    static volatile boolean hasCigarette = false;
    static volatile boolean hasBreakfast = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                lock.lock();
                while (!hasCigarette) {
                    try {
                        waitCigaretteQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("等到烟了...");
            }finally {
                lock.unlock();
            }
        }, "等烟线程").start();

        new Thread(() -> {
            try {
                lock.lock();
                while (!hasBreakfast) {
                    try {
                        waitBreakfastQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("等到早餐了...");
            }finally {
                lock.unlock();
            }
        }, "等早餐线程").start();

        Thread.sleep(1000);
        sendBreakfast();
        Thread.sleep(1000);
        sendCigarette();
    }

    public static void sendCigarette(){
        lock.lock();
        try {
            log.info("烟来了....");
            hasCigarette = true;
            waitCigaretteQueue.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void sendBreakfast(){
        lock.lock();
        try {
            log.info("早餐来了....");
            hasBreakfast = true;
            waitBreakfastQueue.signal();
        }finally {
            lock.unlock();
        }
    }

}
