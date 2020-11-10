package xyz.bugcoder.concurrent;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-09 18:31
 */
public class NoneLock {

    static class ThreadA implements Runnable {
        @Override
        public synchronized void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("Thread A " + i);
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("Thread B " + i);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}