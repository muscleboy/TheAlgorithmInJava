package xyz.bugcoder.concurrent.heima_5_JMM;

import lombok.extern.slf4j.Slf4j;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 17:20
 */

// 希望 doInit()方法只能被调用一次
@Slf4j
public class BalkingModeExcercise {

    boolean initialized = false;

    Thread t;

    void init(){
        synchronized (this){
            if (initialized){
                return;
            }
            doInit();
            initialized = true;
        }

        t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                log.info("init....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t");
        t.start();
    }

    void doInit(){
        log.info("doInit....");
    }

    public static void main(String[] args) {

        BalkingModeExcercise bm = new BalkingModeExcercise();

        bm.init();
        bm.init();
        bm.init();

    }

}
