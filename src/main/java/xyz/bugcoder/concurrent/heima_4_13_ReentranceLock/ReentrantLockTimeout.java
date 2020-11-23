package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 19:47
 */
@Slf4j
public class ReentrantLockTimeout {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            log.info("qidong...");

//            if (!lock.tryLock()) {
////                log.info("获取失败、立刻退出");
////                return;
////            }
            try {
                if (!lock.tryLock(3, TimeUnit.SECONDS)) {
                    log.info("获取失败、3s退出");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                log.info("t1 get lock");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        log.info("main get lock");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            log.info("main unlock");
        }

    }

}
