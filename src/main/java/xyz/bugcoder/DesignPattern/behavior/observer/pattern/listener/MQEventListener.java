package xyz.bugcoder.DesignPattern.behavior.observer.pattern.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.behavior.observer.LotteryResult;

public class MQEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录用户 {} 摇号结果(MQ)：{}", result.getuId(), result.getMsg());
    }

}
