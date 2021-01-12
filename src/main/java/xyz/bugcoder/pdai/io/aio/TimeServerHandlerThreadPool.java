package xyz.bugcoder.pdai.io.aio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Package: xyz.bugcoder.pdai.io.aio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 21:21
 */
public class TimeServerHandlerThreadPool {

    private ExecutorService executorService;

    public TimeServerHandlerThreadPool(int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize,
                120L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable task) {
        executorService.execute(task);
    }

}
