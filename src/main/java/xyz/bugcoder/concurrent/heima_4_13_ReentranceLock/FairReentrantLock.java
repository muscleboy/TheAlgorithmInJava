package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 20:02
 */

// 公平锁一般没有必要，会降低并发度
@Slf4j
public class FairReentrantLock {

    // 默认是 非公平(不是先到先得)， 插入的线程有机会在中间输出
    static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {

        log.info("isFair: " + lock.isFair());
        lock.lock();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    log.info(Thread.currentThread().getName() +  " running...");
                }finally {
                    lock.unlock();
                }
            }, "t" + i).start();
        }

        Thread.sleep(1000);
        new Thread(() -> {
            log.info(Thread.currentThread().getName() + " start....");
            lock.lock();
            try {
                log.info(Thread.currentThread().getName() +  " running...");
            }finally {
                lock.unlock();
            }
            // 强行插入的线程有机会在中间输出
        }, "强行插入的线程").start();
        lock.unlock();

    }

}
