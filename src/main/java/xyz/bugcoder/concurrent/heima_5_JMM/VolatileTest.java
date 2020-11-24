package xyz.bugcoder.concurrent.heima_5_JMM;

import lombok.extern.slf4j.Slf4j;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 15:10
 */

@Slf4j
public class VolatileTest {

    // volatile 只能修饰成员变量和静态成员变量，他可以避免线程从自己的工作缓存中查找变量的值，
    // 必须到主存中获取 它的值，线程操作 volatile 变量都是直接操作主存
    volatile static boolean run = true;

    // synchronized 关键字既可以保证原子性、也能保证可见性
    // 但 synchronized 属于重量级操作，性能低
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (run){
                synchronized (lock){
                    if (!run){

                    }
                }
            }
        }, "t1").start();

        Thread.sleep(1000);
        // 这样并不能使得 t1 线程停下来
        // 因为每次都从得读取 run 遍历，jit 编译器为了快，缓存了它的值，所有读取到的并不是最新的
        // 加了 volatile 关键字修饰即可，
//        log.info("stop t1...");
////        run = false;

        log.info("stop t1...");
        synchronized (lock){
            run = false;
        }

        System.out.println();
    }

}
