package xyz.bugcoder.concurrent.heima_5_JMM;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 16:27
 */

// Happen_Before规则 -- synchronized
// 对于两个操作A和B，这两个操作可以在不同的线程中执行。如果A Happens-Before B，
// 那么可以保证，当A操作执行完后，A操作的执行结果对B操作是可见的。
public class HappenBefore_1 {

    static int x;
    static Object m = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (m){
                x = 10;
            }
        }, "t1").start();

        // 此时 m 是可见的
        new Thread(() -> {
            synchronized (m){
                System.out.println(x);
            }
        }, "t2").start();

    }

}
