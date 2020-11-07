package xyz.bugcoder.DesignPattern.behavior.command.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.command.pattern
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 17:33
 */
// 在调⽤者的具体实现中，提供了菜品的添加和菜单执⾏烹饪。这个过程是命令模式的具体调⽤，通 过外部将菜品和厨师传递进来⽽进⾏具体的调⽤。
public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private List<ICuisine> cuisineList = new ArrayList<>();

    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }

}
