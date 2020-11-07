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
public class JiangSuCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() { logger.info("江苏厨师，烹饪苏菜，宫廷第⼆⼤菜系，古今国宴上最受⼈欢迎的菜 系。"); }

}
