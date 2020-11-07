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
public class ShanDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() { logger.info("⼭东厨师，烹饪鲁菜，宫廷最⼤菜系，以孔府⻛风味为⻰龙头"); }

}
