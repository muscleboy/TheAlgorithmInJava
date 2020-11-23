package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 20:46
 */

// 多线程打印，abc 5次，例如 abcabcabcabcabc
// ReentrantLock 实现

@Slf4j
public class Excercise_4 {

    public static void main(String[] args) throws InterruptedException {

        AwaitSignal as = new AwaitSignal(5);
        Condition a = as.newCondition();
        Condition b = as.newCondition();
        Condition c = as.newCondition();

        new Thread(() -> {
            as.print("a", a, b);
        }).start();

        new Thread(() -> {
            as.print("b", b, c);
        }).start();

        new Thread(() -> {
            as.print("c", c, a);
        }).start();

        // 主线程发起 开始
        Thread.sleep(1000);
        as.lock();
        try {
            log.info("start...");
            a.signal();
        }finally {
            as.unlock();
        }

    }
}

//
class AwaitSignal extends ReentrantLock {

    private int loopTime;

    public AwaitSignal(int loopTime) {
        this.loopTime = loopTime;
    }

    public void print(String s, Condition cur, Condition next){
        for (int i = 0; i < loopTime; i++) {
            lock();
            try {
                // 进入各自的休息室
                cur.await();
                System.out.print(s);
                // 唤醒下一个线程
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}
