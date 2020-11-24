package xyz.bugcoder.concurrent.heima_5_JMM;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 16:27
 */

// Happen_Before规则 -- 中断规则
// 假设两个线程A和B，A先做了一些操作operationA，然后调用B线程的interrupt方法。
// 当B线程感知到自己的中断标识被设置时(通过抛出InterruptedException，
// 或调用interrupted和isInterrupted),operationA中的操作结果对B都是可见的。
public class HappenBefore_5 {

    static int x;

    public static void main(String[] args) throws InterruptedException {

        Thread t2 = new Thread(() -> {
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("t2: " + x);
                    break;
                }
            }
        }, "t2");
        t2.start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                x = 10;
                t2.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        while (!t2.isInterrupted()){
            Thread.yield();
        }
        System.out.println("main: " + x);

    }

}
