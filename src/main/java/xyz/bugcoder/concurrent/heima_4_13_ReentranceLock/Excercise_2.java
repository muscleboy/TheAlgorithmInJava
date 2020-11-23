package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 20:58
 */

// 多线程打印，先打印 2，再打印 1
// park & unpark 实现
@Slf4j
public class Excercise_2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.info("1");
        }, "t1");

        t1.start();
        new Thread(() -> {
            log.info("2");
            LockSupport.unpark(t1);
        }, "t2").start();

    }

}