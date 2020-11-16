package xyz.bugcoder.concurrent.chapter_1;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 18:43
 */
public class InterruptTest {

    // 主线程调用 threadA.interrupt()方法让 threadA 中断，退出循环
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted())
                    System.out.println("hello~~~");
            }
        });

        threadA.start();
        Thread.sleep(1000);

        System.out.println("main-thread interrupt threadA");
        threadA.interrupt();

        threadA.join();
        System.out.println("main is over~~");
    }

}
