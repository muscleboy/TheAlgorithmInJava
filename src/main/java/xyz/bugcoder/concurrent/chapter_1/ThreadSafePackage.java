package xyz.bugcoder.concurrent.chapter_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-19 16:18
 */
public class ThreadSafePackage {

    private static Logger logger = LoggerFactory.getLogger("Test");

    public static void main(String[] args) throws InterruptedException {
        Hashtable<String, String> table = new Hashtable<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                table.put("k1", "v1");
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                table.put("k2", "v2");
            }
        }, "t2");

        t1.start();
        t2.start();
        logger.info("table: " + table);
    }

}
