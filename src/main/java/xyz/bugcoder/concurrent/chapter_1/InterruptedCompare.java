package xyz.bugcoder.concurrent.chapter_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-17 17:24
 */
public class InterruptedCompare {

    private static Logger logger = LoggerFactory.getLogger("Test");

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            logger.info("debug...");
            LockSupport.park();
            logger.info("unpark");
            // interrupted会清除打断标记， 所以 true 之后，park 往下的代码不会继续执行(park 失效)
            logger.info("status: " + Thread.interrupted());

            // 再次标记为false，unpark()会执行
//            logger.info("status: " + Thread.interrupted());
//            LockSupport.unpark(Thread.currentThread());
            logger.info("unpark22");
        }, "t1");

        t1.start();

        sleep(1);
        t1.interrupt();
    }

}
