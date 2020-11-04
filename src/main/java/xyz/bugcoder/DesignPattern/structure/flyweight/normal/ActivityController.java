package xyz.bugcoder.DesignPattern.structure.flyweight.normal;

import xyz.bugcoder.DesignPattern.structure.flyweight.Activity;
import xyz.bugcoder.DesignPattern.structure.flyweight.Stock;

import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.flyweight.normal
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 16:56
 */
public class ActivityController {

    public Activity queryActivityInfo(Long id) {

        // 模拟从实际业务应⽤从接⼝中获取活动信息
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("图书嗨乐");
        activity.setDesc("图书优惠券分享激励分享活动第⼆期");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000, 1));
        return activity;

    }

}
