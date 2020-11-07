package xyz.bugcoder.DesignPattern.behavior.command.pattern;

import xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.impl.GuangDongCook;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.impl.JiangSuCook;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.impl.ShanDongCook;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cook.impl.SiChuanCook;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.ICuisine;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl.GuangDoneCuisine;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl.JiangSuCuisine;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl.ShanDongCuisine;
import xyz.bugcoder.DesignPattern.behavior.command.pattern.cuisine.impl.SiChuanCuisine;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.command.pattern
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 17:35
 */
//命令模式的使⽤场景需要分为三个⽐较⼤的块； 命令(点菜，下单) 、 实现(厨师) 、 调⽤者(服务员) ，
// ⽽这三块内容的拆分也是选择适合场景的关键因素，经过这样的拆分可以让逻辑具备单 ⼀职责的性质，便于扩展。

// 优缺点：降低了耦合性也⽅便其他的命令和实现的扩展， 但也增加了很多类，需要进行管理
public class Test {

    @org.junit.Test
    public void test() {

        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单f
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }

}
