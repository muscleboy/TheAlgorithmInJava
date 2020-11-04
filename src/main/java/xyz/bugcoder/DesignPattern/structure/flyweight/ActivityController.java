package xyz.bugcoder.DesignPattern.structure.flyweight;

import xyz.bugcoder.DesignPattern.structure.flyweight.pattern.ActivityFactory;
import xyz.bugcoder.DesignPattern.structure.flyweight.pattern.util.RedisUtils;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.flyweight
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 17:02
 */
public class ActivityController {

    private RedisUtils redisUtils = new RedisUtils();

    // 使⽤了享元⼯⼚获取活动信息，查询后将库存信息在补充上。因为库存信息是变化 的，⽽活动信息是固定不变的。
    // 最终通过统⼀的控制类就可以把完整包装后的活动信息返回给调⽤⽅。
    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
