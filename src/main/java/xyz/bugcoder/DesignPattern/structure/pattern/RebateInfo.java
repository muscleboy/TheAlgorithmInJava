package xyz.bugcoder.DesignPattern.structure.pattern;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:29
 */

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
