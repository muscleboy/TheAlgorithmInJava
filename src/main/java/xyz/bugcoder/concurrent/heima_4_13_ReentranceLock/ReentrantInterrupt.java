package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 18:21
 */

@Slf4j
public class ReentrantInterrupt {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            log.info("启动...");
            try {
                // 如果只是 lock.lock()，并不会打断成功
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info("等待锁的过程被中断...");
                return;
            }
            try {
                log.info("t1获得锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        log.info("main获得锁");
        t1.start();
        try {
            Thread.sleep(1000);
            t1.interrupt();
            log.info("main打断 t1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
