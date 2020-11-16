package xyz.bugcoder.concurrent.chapter_1;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 17:41
 */
public class WaitNotifyInterupt {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---begin---");
                    synchronized (obj){
                        // 挂起当前线程，其他线程中断我，我抛异常
                        obj.wait();
                    }
                    System.out.println("---end---");
                } catch (InterruptedException e) {
                    System.out.println("我被其他线程中断了");
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA----");
        // 主线程中断 threadA
        threadA.interrupt();
        System.out.println("---end interrupt threadA----");
    }

}
