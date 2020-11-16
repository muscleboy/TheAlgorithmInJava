package xyz.bugcoder.concurrent;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 16:55
 */
public class DeadLockDemo {

    private static Object res1 = new Object();
    private static Object res2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (res1){
                System.out.println(Thread.currentThread() + " get res1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " waiting res2");
                synchronized (res2){
                    System.out.println(Thread.currentThread() + " get res2");
                }
            }
        }, "线程1").start();

        // 为什么能避免死锁(res2, res1)?
        //  破坏循环等待条件(res1, res2)
        new Thread(() -> {
            synchronized (res1){
                System.out.println(Thread.currentThread() + " get res1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " waiting res2");
                synchronized (res2){
                    System.out.println(Thread.currentThread() + " get res2");
                }
            }
        }, "线程2").start();
    }

}
