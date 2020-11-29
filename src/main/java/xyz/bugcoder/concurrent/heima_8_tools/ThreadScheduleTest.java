package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 17:54
 */
@Slf4j
public class ThreadScheduleTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        timerTest();
//        schedule();

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

        // start 1 秒之后，以后每次隔 period 秒，执行一次
//        log.info("start");
//        pool.scheduleAtFixedRate(() -> {
//            log.info("running....");
//        }, 1, 1, TimeUnit.SECONDS);

        // 首先是 start，然后隔了一秒开始 running，因为代码执行了 2 秒，所以之后的执行为间隔 2 秒
//        log.info("start");
//        pool.scheduleAtFixedRate(() -> {
//            log.info("running....");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 1, 1, TimeUnit.SECONDS);

        // start 之后，隔了 1 秒开始执行，之后是运行是 每次代码运行时间 + 延迟时间
        // 运行完之后 + 延迟时间
//        log.info("start");
//        pool.scheduleWithFixedDelay(() -> {
//            log.info("running....");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 1, 1, TimeUnit.SECONDS);


        // 异常处理
        // 1.自己主动 try/catch 处理
        // 2.使用 future 返回值接收，当出现异常时，会被封装在 future 中，可以通过 future.get();
        Future<Boolean> f = pool.submit(() -> {
            log.info("....");
            int i = 10/0;
            return true;
        });

        log.info("result: {}", f.get());

    }



    private static void schedule() {
        // 通过定时任务解决 Timer 的问题
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        // 出现异常并不会影响执行
        pool.schedule(() -> {
            log.info("1....");
            int i = 10/0;
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            log.info("2....");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            log.info("3....");
        }, 1, TimeUnit.SECONDS);
    }

    private static void timerTest() {
        Timer timer = new Timer();

        TimerTask t1 = new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
//                Thread.sleep(3000);
                int i = 10/0;
                log.info("task 1....");
            }
        };

        TimerTask  t2 = new TimerTask() {
            @Override
            public void run() {
                log.info("task 2....");
            }
        };

        // Timer内只有一个线程来控制顺序执行队列中的任务，所以如果任务 1 延迟了，会影响到任务 2
        //   并且如果任务 1 出现了异常，任务 2 也无法正常执行
        timer.schedule(t1, 1000);
        timer.schedule(t2, 1000);
    }

}
