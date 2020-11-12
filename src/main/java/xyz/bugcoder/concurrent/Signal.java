package xyz.bugcoder.concurrent;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 17:27
 */
public class Signal {

    static volatile int signal = 0;

    static class ThreadA implements Runnable{

        @Override
        public void run() {
            while (signal < 5){
                if (signal % 2 == 0){
                    System.out.println("ThreadA: " + signal);
                    // 这里是 非原子性 操作
                    signal ++;
                }
            }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            while (signal < 5){
                if (signal % 2 == 1){
                    System.out.println("ThreadB: " + signal);
                    // 这里是 非原子性 操作，会出现 signal = 5的情况
                    signal ++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }

}
