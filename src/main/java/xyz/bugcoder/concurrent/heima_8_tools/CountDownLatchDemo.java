package xyz.bugcoder.concurrent.heima_8_tools;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: 多线程模拟多人游戏游戏加载情况
 * @createTime 2020-11-30 20:01
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        // 资源数
        CountDownLatch count = new CountDownLatch(10);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        String[] all = new String[10];

        Random r = new Random();
        for (int j = 0; j < 10; j++) {
            int k = j;
            pool.submit(() -> {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(r.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    all[k] = i + "%";
                    System.out.print("\r" + Arrays.toString(all));
                }
                count.countDown();
            });
        }

        count.await();
        System.out.println("\n游戏开始！");
        pool.shutdown();

    }

}
