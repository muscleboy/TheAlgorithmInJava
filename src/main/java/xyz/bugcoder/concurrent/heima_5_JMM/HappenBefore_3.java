package xyz.bugcoder.concurrent.heima_5_JMM;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 16:27
 */

// Happen_Before规则 -- 线程 start 之前对变量的写，在该线程 start 后，对该变量的读可见
public class HappenBefore_3 {

    static int x;

    public static void main(String[] args) {

        x = 10;

        // 此时 x 是可见的
        new Thread(() -> {
            System.out.println(x);
        }, "t1").start();

    }

}
