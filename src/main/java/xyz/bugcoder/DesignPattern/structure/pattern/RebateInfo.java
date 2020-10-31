package xyz.bugcoder.DesignPattern.structure.pattern;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:29
 */

// 适配器优点：可以让代码⼲净整洁易于维护、减少⼤量重复的判断和使⽤、让代码更加易于维护和拓展。
// 尤其是我们对MQ这样的多种消息体中不同属性同类的值，进⾏适配再加上代理类，就可以使⽤简 单的配置⽅式接⼊对⽅提供的MQ消息，⽽不需要⼤量重复的开发。⾮常利于拓展。

// mq的基础字段，通过适配器(MQAdapter)将具体的业务的字段转成mq的字段
@Data
public class RebateInfo {

    // 用户ID
    private String userId;
    // 业务ID
    private String bizId;
    // 业务时间
    private String bizTime;
    // 业务描述
    private String desc;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
