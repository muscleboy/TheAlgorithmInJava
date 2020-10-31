package xyz.bugcoder.DesignPattern.structure.adapter.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.adapter.mq
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:06
 */
@Data
public class POPOrderDelivered {

    private String uId; // ⽤户ID
    private String orderId; // 订单号
    private Date orderTime; // 下单时间
    private Date sku; // 商品
    private Date skuName; // 商品名称
    private BigDecimal decimal; // ⾦额

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
