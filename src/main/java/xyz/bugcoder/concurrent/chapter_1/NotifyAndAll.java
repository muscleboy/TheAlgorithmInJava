package xyz.bugcoder.concurrent.chapter_1;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 17:59
 */
public class NotifyAndAll {

    private static volatile Object resA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resA){
                    System.out.println("threadA get resA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resA){
                    System.out.println("threadB get resA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resA){
                    System.out.println("threadC begin notify");
//                    resA.notify();
                    // notifyAll只会唤醒在它之前 wait 的线程
                    // 如：7 以下情况并不会唤醒线程 B
//                    threadA.start();
//                    threadC.start();
//                    Thread.sleep(1000);
//                    threadB.start();
                    resA.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over~~");
    }

}
