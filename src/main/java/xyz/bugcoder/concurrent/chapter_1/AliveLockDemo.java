package xyz.bugcoder.concurrent.chapter_1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: 活锁🔐
 * @createTime 2020-11-23 17:47
 */

// 活锁🔐：线程之间互相改变对方的退出条件，导致线程一直运行
// 解决：睡眠时间随机

@Slf4j
public class AliveLockDemo {

    static volatile int count = 10;

    public static void main(String[] args) {

        new Thread(() -> {
            while (count > 0){
                try {
                    Thread.sleep(500);
                    count --;
                    log.info("t1 count: " + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (count < 20){
                try {
                    Thread.sleep(500);
                    count ++;
                    log.info("t2 count: " + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

    }

}
