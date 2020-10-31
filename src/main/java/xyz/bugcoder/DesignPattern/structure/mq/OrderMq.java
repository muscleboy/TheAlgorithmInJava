package xyz.bugcoder.DesignPattern.structure.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.mq
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:05
 */
@Data
public class OrderMq {

    // ⽤户ID
    private String uid;
    // 商品
    private String sku;
    // 订单ID
    private String orderId;
    // 下单时间
    private Date createOrderTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
