package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: 读写锁
 * @createTime 2020-11-30 18:20
 */
public class ReentrantRWLockTest {

    public static void main(String[] args) throws InterruptedException {

        Data d = new Data();

        new Thread(() -> {
            try {
                d.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
                d.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

    }

}

//19:25:16.216 [t1] INFO  x.b.concurrent.heima_8_tools.Data - 获取读锁...
//19:25:16.218 [t1] INFO  x.b.concurrent.heima_8_tools.Data - 读....
//19:25:16.316 [t2] INFO  x.b.concurrent.heima_8_tools.Data - 获取写锁....
//19:25:17.219 [t1] INFO  x.b.concurrent.heima_8_tools.Data - 释放读锁...
//19:25:17.219 [t2] INFO  x.b.concurrent.heima_8_tools.Data - 写...
//19:25:18.221 [t2] INFO  x.b.concurrent.heima_8_tools.Data - 释放写锁....

@Slf4j
class Data{

    private int data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    // 读写锁(读共享，写互斥)
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public int read() throws InterruptedException {
        log.info("获取读锁...");
        r.lock();
        try {
            log.info("读....");
            Thread.sleep(1000);
            return data;
        }  finally {
            log.info("释放读锁...");
            r.unlock();
        }
    }

    public void write() throws InterruptedException {
        log.info("获取写锁....");
        w.lock();
        try {
            log.info("写...");
            Thread.sleep(1000);
        } finally {
            log.info("释放写锁....");
            w.unlock();
        }
    }

}
