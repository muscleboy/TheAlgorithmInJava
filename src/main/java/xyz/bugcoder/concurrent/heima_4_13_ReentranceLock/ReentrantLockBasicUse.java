package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 18:15
 */
// ReentrantLock特点：
//   可中断
//   可设置超时时间
//   可设置为公平锁
//   支持多个条件变量

//   和 synchronized一样，都可重入

@Slf4j
public class ReentrantLockBasicUse {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        // 基本使用
        lock.lock();
        try {
            // 业务逻辑
            log.info("enter main....");
            m1();
        }finally {
            lock.unlock();
        }
    }

    public static void m1(){
        lock.lock();
        try {
            log.info("enter m1....");
            m2();
        }finally {
            lock.unlock();
        }
    }

    public static void m2(){
        lock.lock();
        try {
            log.info("enter m2....");
        }finally {
            lock.unlock();
        }
    }

}
