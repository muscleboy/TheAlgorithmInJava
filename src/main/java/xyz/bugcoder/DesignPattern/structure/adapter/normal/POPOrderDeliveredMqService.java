package xyz.bugcoder.DesignPattern.structure.adapter.normal;

import com.alibaba.fastjson.JSON;
import xyz.bugcoder.DesignPattern.structure.adapter.mq.POPOrderDelivered;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:25
 */
public class POPOrderDeliveredMqService {

    public void onMessage(String message){

        POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

        mq.getDecimal();
        mq.getOrderId();
        mq.getOrderTime();
        mq.getSku();
        mq.getSkuName();
        mq.getUId();

    }

}
