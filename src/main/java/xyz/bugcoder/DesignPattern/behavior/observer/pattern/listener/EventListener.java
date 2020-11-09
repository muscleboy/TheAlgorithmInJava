package xyz.bugcoder.DesignPattern.behavior.observer.pattern.listener;


import xyz.bugcoder.DesignPattern.behavior.observer.LotteryResult;

public interface EventListener {

    void doEvent(LotteryResult result);

}
