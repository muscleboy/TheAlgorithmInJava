package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 16:43
 */

@Slf4j
public class ThreadSubmitTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 提交任务，通过 future 获取返回结果
        Future<String> future = pool.submit(() -> {
            log.info("deal....");
            Thread.sleep(1000);
            return "ok";
        });

        log.info("result: {}", future.get());

    }

}
