package xyz.bugcoder.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-14 17:31
 */
// 必须等所有的前置任务都完成，才能开始执行本线程的任务。
public class CountDownLatchDemo {

    static class PreTaskThread implements Runnable{

        private String task;
        private CountDownLatch countDownLatch;

        public PreTaskThread(String task, CountDownLatch countDownLatch) {
            this.task = task;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                System.out.println(task + " - 任务完成! ");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(() -> {
           try {
               System.out.println("等待数据加载....");
               System.out.println(String.format("还有 %s 个前置任务" , countDownLatch.getCount()));
               countDownLatch.await();
               System.out.println("数据加载完成，准备开启游戏!!!");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }).start();

        new Thread(new PreTaskThread("加载背景音乐", countDownLatch)).start();
        new Thread(new PreTaskThread("加载地图", countDownLatch)).start();
        new Thread(new PreTaskThread("加载人物", countDownLatch)).start();
    }

}
