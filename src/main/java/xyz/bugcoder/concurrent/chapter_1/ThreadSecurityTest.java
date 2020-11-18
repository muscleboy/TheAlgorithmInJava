package xyz.bugcoder.concurrent.chapter_1;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-18 23:50
 */
public class ThreadSecurityTest {

    private static Object lock = new Object();

    private static int counter = 0;

    // 线程不安全问题, 原因 ++, --都不是原子操作
    // ++对应的字节码：
    //  getstatic i   // 获取静态变量的值
    //  iconst_1      // 准备常量 1
    //  iadd          // 自增操作
    //  putstastic    // 修改后写入静态变量
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public  void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (lock){
                        counter ++ ;
                    }
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public  void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (lock){
                        counter --;
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("counter: " + counter);
    }

}
