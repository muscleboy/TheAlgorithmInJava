package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 17:24
 */

@Slf4j
public class ThreadHungryTest {

    static final List<String> menu = Arrays.asList("红烧鱼", "清蒸鱼", "红烧小龙虾", "油焖大虾");

    static Random random = new Random();

    static String cooking() {
        return menu.get(random.nextInt(menu.size()));
    }

    public static void main(String[] args) {

        ExecutorService waiterPool = Executors.newFixedThreadPool(1);
        ExecutorService cookingPool = Executors.newFixedThreadPool(1);

        // 当线程不足时，会导致线程饥饿
        // 根本解决方案：
        //    不同的任务使用不同的线程池
        waiterPool.execute(() -> {
            log.info("处理点餐...");
            Future<String> future = cookingPool.submit(() -> {
                log.info("做菜...");
                return cooking();
            });

            try {
                log.info("上菜 {}....", future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        waiterPool.execute(() -> {
            log.info("处理点餐...");
            Future<String> future = cookingPool.submit(() -> {
                log.info("做菜...");
                return cooking();
            });

            try {
                log.info("上菜 {}....", future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

}
