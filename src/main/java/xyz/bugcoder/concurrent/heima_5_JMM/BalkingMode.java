package xyz.bugcoder.concurrent.heima_5_JMM;

import lombok.extern.slf4j.Slf4j;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 15:36
 */
public class BalkingMode {

    public static void main(String[] args) {
        TwoPhaseTermination2 tpt = new TwoPhaseTermination2();
        tpt.start();
        tpt.start();
        tpt.start();
    }

}


// 两阶段终止模式
@Slf4j
class TwoPhaseTermination2{

    private Thread monitor;

    // 犹豫模式，就是看这个是否已运行，是直接 return，不是才继续往下运行
    private static boolean starting = false;

    // 启动线程
    public void start(){
        // synchronized 只保护 需要保护的代码，其他代码应放在synchronized外，可以提高性能
        synchronized (this){
            if (starting){
                return;
            }
            starting = true;
        }


        monitor = new Thread(() -> {
            try {
                Thread.sleep(1000);
                log.info("start monitor thread....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "monitor");
        monitor.start();
    }

    // 优雅关闭线程
    public void stop(){
        monitor.interrupt();
    }

}