package xyz.bugcoder.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-08 17:29
 */
public class Test {

    public static class MyThread extends Thread{
        public void run(){
            System.out.println("thread-name: "+Thread.currentThread().getName() + ", thread-group-name: " + Thread.currentThread().getThreadGroup().getName() + " : i am a child thread");
        }
    }

    public static class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("thread-name: "+Thread.currentThread().getName() + ", thread-group-name: " + Thread.currentThread().getThreadGroup().getName() +  " : i am a child thread, created by Runnable!!");
        }
    }

    static class CallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "thread-name: "+Thread.currentThread().getName() + ", thread-group-name: " + Thread.currentThread().getThreadGroup().getName() +  " : i am a child thread, created by Callable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 方式1
        // 这里只是创建了线程
        MyThread thread = new MyThread();
        // 启动线程
        thread.start();

        // 方式2
        // 创建线程
        RunnableTask task1 = new RunnableTask();
        RunnableTask task2 = new RunnableTask();
        // 启动
        new Thread(task1, "RunnableTask1").start();
        new Thread(task2, "RunnableTask2").start();

        // 方式3
        // 创建异步任务
        FutureTask<String> futureTask1 = new FutureTask<>(new CallerTask());
        FutureTask<String> futureTask2 = new FutureTask<>(new CallerTask());
        // 启动
        new Thread(futureTask1, "FutureTask1").start();
        new Thread(futureTask2, "FutureTask2").start();

        // 等待线程执行完毕，并返回结果
        String s1 = futureTask1.get();
        String s2 = futureTask2.get();
        System.out.println(s1);
        System.out.println(s2);
    }

    @org.junit.Test
    public void test() throws InterruptedException {

        Thread a = new Thread(() -> testMethod(), "a");

        Thread b = new Thread(() -> testMethod(), "b");

        a.start();
        Thread.sleep(500l);
        b.start();
        System.out.println(a.getName() + ": " + a.getState());
        System.out.println(b.getName() + ": " + a.getState());
    }

    private synchronized void testMethod(){
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
