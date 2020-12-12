package xyz.bugcoder.pdai.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @Package: xyz.bugcoder.pdai.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-12 16:06
 */

// 面试题 多线程交替输出 1A2B3C....
public class LockSupportSrc {

    static Thread t1, t2;
    static char[] c1 = "12345".toCharArray();
    static char[] c2 = "ASDFG".toCharArray();

    public static void main(String[] args) {

//        method1();
//        method2();

    }

    // park, unpark
    private static void method1() {

        t1 = new Thread(() -> {
            for (char c : c1) {
                System.out.print(c);
                LockSupport.park();
                LockSupport.unpark(t2);
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : c2) {
                LockSupport.unpark(t1);
                System.out.print(c);
                LockSupport.park();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    // synchronized wait notify
    private static void method2(){

        Object o = new Object();

        char[] c1 = "12345".toCharArray();
        char[] c2 = "ABCDF".toCharArray();

        t1 = new Thread(() -> {
            synchronized (o){
                for (char c : c1) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序正常结束
                o.notify();
            }

        });

        t2 = new Thread(() -> {
            synchronized (o){
                for (char c : c2) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        });

        t1.start();
        t2.start();
    }

}
