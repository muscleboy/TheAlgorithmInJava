package xyz.bugcoder.concurrent.chapter_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 18:25
 */
public class SleepTest {

    // 创建个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadA is in sleep");
                    Thread.sleep(2000);
                    System.out.println("threadA is awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadB is in sleep");
                    Thread.sleep(2000);
                    System.out.println("threadB is awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });

        // 睡眠期间并没有释放锁，睡完后才释放
        // 也就是说 sleep 只会释放资源，并不会释放锁
        threadA.start();
        threadB.start();
    }

}
