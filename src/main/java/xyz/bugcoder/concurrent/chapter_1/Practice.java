package xyz.bugcoder.concurrent.chapter_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-17 18:26
 */
public class Practice {

    private static Logger logger = LoggerFactory.getLogger("Practice");

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                logger.info("洗水壶需要 1 分钟....");
                Thread.sleep(1000);
                logger.info("烧开水 15 分钟....");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "烧水壶");

        Thread t2 = new Thread(() -> {
            try {
                logger.info("洗茶壶需要 2 分钟....");
                Thread.sleep(2000);
                logger.info("洗茶杯需要 1 分钟....");
                Thread.sleep(1000);
                logger.info("拿茶叶需要 1 分钟....");
                Thread.sleep(1000);
                t1.join();

                logger.info("开始泡茶....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "准备工作");

        t1.start();
        Thread.sleep(50);
        t2.start();
    }

}
