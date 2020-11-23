package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 20:58
 */

// 多线程打印，先打印 2，再打印 1
// wait & notify 实现

@Slf4j
public class Excercise_1 {

    static Object lock = new Object();

    static boolean is2Printed = false;

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock){
                while (!is2Printed){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("1");
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock){
                log.info("2");
                is2Printed = true;
                lock.notify();
            }
        }, "t2").start();

    }

}
