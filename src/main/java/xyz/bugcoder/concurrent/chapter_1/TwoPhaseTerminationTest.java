package xyz.bugcoder.concurrent.chapter_1;

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

    // 启动线程
    public void start(){
        monitor = new Thread(() -> {
            while (true){
                Thread currentThread = Thread.currentThread();
                boolean flag = currentThread.isInterrupted();
                if (flag){
                    logger.info("线程被打断，处理后事....");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    logger.info("监控日志....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 发生 InterruptedException 中断标记被设为 false
                    // 所以这里需要重新设置打断标记，不然会一直执行 try 中的内容
                    currentThread.interrupt();
                }
            }
        }, "monitor");

        monitor.start();
    }

    // 优雅关闭线程
    public void stop(){
        monitor.interrupt();
    }

}