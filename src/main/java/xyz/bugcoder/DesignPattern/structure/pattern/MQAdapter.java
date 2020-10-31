package xyz.bugcoder.DesignPattern.structure.pattern;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:30
 */

// 把不同类型MQ种的各种属性，映射成我们需要的属性并返 回。就像⼀个属性中有 ⽤户ID;uId ，映射到我们需要的； userId ，做统⼀处理。
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-10-31 18:03
    * @Desc: 把业务的字段映射(转换)成 mq的字段
     * @param map : {number=100001, accountDate=1591024816000, address=河北省.廊坊市.广阳区.大学里职业技术学院, desc=在校开户}
     * @param link : {bizId=number, userId=number, bizTime=accountDate, desc=desc}, 业务字段和mq字段的对应关系
    * @Returns: RebateInfo
    **/
    public static RebateInfo filter(Map map, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        System.out.println("map: " + map);
//        System.out.println("link: " + link);
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = map.get(link.get(key));
            // 反射, 获取到setter方法setBizId....
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
//        System.out.println("rebateInfo: " + rebateInfo);
        return rebateInfo;
    }

}
