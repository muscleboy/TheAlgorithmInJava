package xyz.bugcoder.concurrent.chapter_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-17 17:39
 */
public class DaemonTest {

    private static Logger logger = LoggerFactory.getLogger("DaemonTest");

    // 默认情况下，Java进程需要等待所以的 Java 线程执行完才会运行结束
    // 但是守护线程例外，非守护线程执行完了，不管守护线程是否执行完，都会被结束
    // 比如 Java 的垃圾回收线程就是守护线程
    // Tomcat 中的 Acceptor 和 Poller 也是守护线程，当收到 shutdown 命令时，会马上结束，不会处理完当前的请求
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                logger.info("守护线程开始运行...");
                Thread.sleep(2000);
                logger.info("守护线程结束运行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "daemon");

        t1.setDaemon(true);
        t1.start();
        Thread.sleep(500);
        logger.info("main线程结束....");
    }

}
