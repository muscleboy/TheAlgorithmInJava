package xyz.bugcoder.concurrent.heima_5_JMM;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 16:27
 */

// Happen_Before规则 -- 传递性
// 如果操作A Happens-Before B，B Happens-Before C，那么可以得出操作A Happens-Before C。
public class HappenBefore_6 {

    static volatile int x;
    static int y;

    public static void main(String[] args) {

        new Thread(() -> {
            y = 10;
            x = 20;
            // 写屏障， 保证 x = 20 之前的代码不会重拍到 这个屏障 之后
            // z = 30;
        }, "t1").start();

        new Thread(() -> {
            // 读屏障，x = 20对 t2 可见，y = 10也对 t2 可见
            System.out.println(x);
            System.out.println(y);
        }, "t2").start();

    }

}
