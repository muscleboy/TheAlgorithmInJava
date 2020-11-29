package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 16:50
 */

@Slf4j
public class ThreadPoolInvokeAll {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService pool = Executors.newFixedThreadPool(2);

//        method1(pool);
//        method2(pool);
//          method3(pool);
          method4(pool);
    }

    private static void method1(ExecutorService pool) throws InterruptedException {

        List<Future<String>> futures = pool.invokeAll(Arrays.asList(
                () -> {
                    log.info("start...");
                    Thread.sleep(1000);
                    return "1";
                },
                () -> {
                    log.info("start...");
                    Thread.sleep(500);
                    return "2";
                },
                () -> {
                    log.info("start...");
                    Thread.sleep(2000);
                    return "3";
                }
        ));

        futures.forEach(f -> {
            try {
                log.info("result: " + f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void method2(ExecutorService pool) throws InterruptedException, ExecutionException {

        // invokeAny是返回一个最先执行完的结果, 其他的就不在执行
        String s = pool.invokeAny(Arrays.asList(
                () -> {
                    log.info("start...");
                    Thread.sleep(1000);
                    return "1";
                },
                () -> {
                    log.info("start...");
                    Thread.sleep(500);
                    return "2";
                },
                () -> {
                    log.info("start...");
                    Thread.sleep(2000);
                    return "3";
                }
        ));

        log.info("result: " + s);
    }

    private static void method3(ExecutorService pool) throws InterruptedException, ExecutionException {

        // shutdown: shutdown之后，不会再接收新的任务，但会把提交的任务执行完，不会阻塞调用线程的执行
        pool.submit(() -> {
            log.info("task1 start....");
            Thread.sleep(1000);
            log.info("task1 finish....");
            return "1";
        });

        pool.submit(() -> {
            log.info("task2 start....");
            Thread.sleep(1000);
            log.info("task2 finish....");
            return "2";
        });

        pool.shutdown();
        log.info("some.....");

        pool.submit(() -> {
            log.info("task3 start....");
            Thread.sleep(1000);
            log.info("task3 finish....");
            return "3";
        });

    }

    private static void method4(ExecutorService pool) throws InterruptedException, ExecutionException {

        // shutdownNow: 不会再接收新的任务，将队列中的任务返回，并用interrupt方式中断正在执行的任务, 也不会阻塞
        pool.submit(() -> {
            log.info("task1 start....");
            Thread.sleep(1000);
            log.info("task1 finish....");
            return "1";
        });

        pool.submit(() -> {
            log.info("task2 start....");
            Thread.sleep(1000);
            log.info("task2 finish....");
            return "2";
        });


        pool.submit(() -> {
            log.info("task3 start....");
            Thread.sleep(1000);
            log.info("task3 finish....");
            return "3";
        });

        pool.shutdownNow();
        log.info("now......");
    }

}
