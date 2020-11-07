package xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl;

import xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.ICook;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.ICuisine;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 17:16
 */
// 在实现的类中都有添加了⼀个厨师类( ICook )，并通过这个类提供的⽅法 进⾏操作命令(烹饪菜品) cook.doCooking() 。
public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
