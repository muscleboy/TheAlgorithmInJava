package xyz.bugcoder.concurrent.chapter_1;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 17:28
 */
public class ReleaseLockDemo {

    private static volatile Object resA = new Object();
    private static volatile Object resB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 获取 resA 锁
                    synchronized (resA){
                        System.out.println("threadA get resA lock");
                        // 获取 resB 锁，并释放 resA 的锁
                        synchronized (resB){
                            System.out.println("threadA get resB lock");
                            System.out.println("threadA release resA lock");
                            resA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    // 获取 resA 锁
                    synchronized (resA){
                        // 上边ThreadA 获取到 resB 锁后，resA.wait()阻塞ThreadA，并且释放 resA，但并没有释放 resB
                        // 所以此时 ThreadB 是获取 resB 时就会被阻塞
                        System.out.println("threadB get resA lock");
                        System.out.println("threadB try get resB lock....");
                        // 获取 resB 锁，并释放 resA 的锁
                        synchronized (resB){
                            System.out.println("threadB get resB lock");
                            System.out.println("threadB release resA lock");
                            resA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
    }

}
