package xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl;

import xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.ICook;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.ICuisine;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 17:16
 */
public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
