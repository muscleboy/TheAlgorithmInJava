package xyz.bugcoder.DesignPattern.structure.flyweight.pattern;

import xyz.bugcoder.DesignPattern.structure.flyweight.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.flyweight.pattern.util
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 16:59
 */

// 享元工厂
//
// 享元模式：，在⼀些有⼤量重复对象可复⽤的场景下，使⽤ 此场景在服务端减少接⼝的调⽤，在客户端减少内存的占⽤。
// 优点：减少内存的使⽤
// 缺点：在⼀些复杂的业务处理场景，很 不容易区分出内部和外部状态，就像我们活动信息部分与库存变化部分。
//      如果不能很好的拆分，就 会把享元⼯⼚设计的⾮常混乱，难以维护。

public class ActivityFactory {

    // 通过 map 结构存放已经从库表或者接⼝中查询到的数据，存放到 内存中，⽤于下次可以直接获取。
    static Map<Long, Activity> activityMap = new HashMap<>();

    public static Activity getActivity(Long id) {

        Activity activity = activityMap.get(id);
        if (null == activity) { //
            // 模拟从实际业务应⽤从接⼝中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第⼆期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);

        }
        return activity;

    }

}
