package xyz.bugcoder.DesignPattern.behavior.observer.pattern.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.behavior.observer.LotteryResult;

public class MessageEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知(短信)：{}", result.getuId(), result.getMsg());
    }

}