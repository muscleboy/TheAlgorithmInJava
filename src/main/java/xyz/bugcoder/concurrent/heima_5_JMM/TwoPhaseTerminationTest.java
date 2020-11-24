package xyz.bugcoder.concurrent.heima_5_JMM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-17 16:15
 */
public class TwoPhaseTerminationTest {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        Thread.sleep(3500);
        tpt.stop();
    }

}


// 两阶段终止模式
class TwoPhaseTermination{

    private Thread monitor;

    private Logger logger = LoggerFactory.getLogger("Test");

    // 改用 volatile 实现两阶段终止模式，修改立即可见
    private volatile static boolean stop = false;

    // 启动线程
    public void start(){
        monitor = new Thread(() -> {
            while (true){
                if (stop){
                    logger.info("线程被打断，处理后事....");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    logger.info("监控日志....");
                } catch (InterruptedException e) {
                }
            }
        }, "monitor");

        monitor.start();
    }

    // 优雅关闭线程
    public void stop(){
        stop = true;
        monitor.interrupt();
    }

}