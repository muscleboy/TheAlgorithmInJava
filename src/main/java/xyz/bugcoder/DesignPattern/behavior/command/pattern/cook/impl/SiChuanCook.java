package xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.ICook;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 17:31
 */
public class SiChuanCook implements ICook {

    // 这⾥是四类不同菜品的厨师, 在这个实现的过程是模拟打了⽇志，相当于通知了厨房⾥具体的厨师进⾏菜品烹饪。
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() { logger.info("四川厨师，烹饪川菜，中国最有特⾊的菜系，也是⺠民间最⼤菜系。"); }

}
