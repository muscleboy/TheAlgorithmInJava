package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 20:46
 */

// 多线程打印，abc 5次，例如 abcabcabcabcabc
// park & unpark 实现

@Slf4j
public class Excercise_5 {

    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) throws InterruptedException {

        ParkUnpark p = new ParkUnpark(5);

        t1 = new Thread(() -> {
            p.print("a", t2);
        }, "t1");

        t2 = new Thread(() -> {
            p.print("b", t3);
        }, "t2");

        t3 = new Thread(() -> {
            p.print("c", t1);
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

        // 主线程首先唤醒
        LockSupport.unpark(t1);
    }
}

class ParkUnpark{

    private int loopTime;

    public ParkUnpark(int loopTime) {
        this.loopTime = loopTime;
    }

    public void print(String s, Thread next){
        for (int i = 0; i < loopTime; i++) {
            LockSupport.park();
            System.out.print(s);
            LockSupport.unpark(next);
        }
    }

}

