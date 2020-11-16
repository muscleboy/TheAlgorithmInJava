package xyz.bugcoder.concurrent.chapter_1;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 18:43
 */
public class InterruptTest2 {

    //  睡眠的线程在睡眠时间内，已满足继续往下执行条件，再睡的话， 浪费时间，可以调用该线程的 interrupt()方法
    //  强制 sleep 方法抛出 InterruptedException 返回，让线程激活
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   System.out.println("threadA begin sleep for 20s");
                   Thread.sleep(20000);
                   System.out.println("threadA awaked!");
               } catch (InterruptedException e) {
                   System.out.println("threadA is interrupt while sleep");
                   return;
               }
                System.out.println("threadA leaving normally");
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
