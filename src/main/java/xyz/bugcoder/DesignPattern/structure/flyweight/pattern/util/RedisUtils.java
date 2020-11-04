package xyz.bugcoder.DesignPattern.structure.flyweight.pattern.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.flyweight.pattern.util
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 17:01
 */
public class RedisUtils {

    // 定时任务⽤于模拟库存的使⽤
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtils() {

        // 上一个任务的开始时间 + 延迟时间 = 下一个任务的开始时间
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 模拟库存消耗
            stock.addAndGet(1);
        }, 0, 100000, TimeUnit.MICROSECONDS);

    }

    public int getStockUsed() {
        return stock.get();
    }

}
