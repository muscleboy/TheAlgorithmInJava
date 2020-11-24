package xyz.bugcoder.concurrent.heima_5_JMM;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 16:27
 */

// Happen_Before规则 -- 线程结束之前对变量的写，该线程结束后，其他线程对这个变量可见
public class HappenBefore_4 {

    static int x;

    public static void main(String[] args) throws InterruptedException {

        // 此时 x 是可见的
        Thread t1 = new Thread(() -> {
            x = 10;
        }, "t1");
        t1.start();

        // 等待 t1，完成，这时候主线程读到是一定是 10
        t1.join();
        System.out.println(x);
    }

}
