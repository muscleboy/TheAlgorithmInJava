package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 16:14
 */

@Slf4j
public class ThreadPollTest {

    public static void main(String[] args) {

        // 线程池大小 2，谁先执行完，谁就执行新的任务
        // 线程工厂：给线程起名字
//        ExecutorService pool = Executors.newFixedThreadPool(2, new ThreadFactory() {
//
//            private AtomicInteger num = new AtomicInteger();
//
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r, "mypool_" + num.getAndIncrement());
//            }
//        });
//
//        pool.execute(() ->{
//            log.info("1");
//        });
//
//        pool.execute(() ->{
//            log.info("2");
//        });
//
//        pool.execute(() ->{
//            log.info("3");
//        });


        // 创建一个按需创建线程的线程池, 初始线程为 0，最大为 Integer.MAX_VALUE
        // 60s 空闲回收
//        ExecutorService cachePool = Executors.newCachedThreadPool();
//
//        cachePool.execute(() ->{
//            log.info("1");
//        });
//
//        cachePool.execute(() ->{
//            log.info("2");
//        });
//
//        cachePool.execute(() ->{
//            log.info("3");
//        });

        // 只有一个线程的线程池
        ExecutorService singlePool = Executors.newSingleThreadExecutor();

        singlePool.execute(() -> {
            log.info("asdf");
        });

        singlePool.execute(() -> {
            int i = 10/0;
        });

        singlePool.execute(() -> {
            log.info("asdfa");
        });

        singlePool.execute(() -> {
            log.info("zxcv");
        });

    }

}
