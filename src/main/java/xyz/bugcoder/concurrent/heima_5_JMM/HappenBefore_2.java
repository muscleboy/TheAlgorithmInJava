package xyz.bugcoder.concurrent.heima_5_JMM;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 16:27
 */

// Happen_Before规则 -- volatile
public class HappenBefore_2 {

    static volatile int x;

    public static void main(String[] args) {

        new Thread(() -> {
            x = 10;
        }, "t1").start();

        // 此时 m 是可见的
        new Thread(() -> {
            System.out.println(x);
        }, "t2").start();

    }

}
