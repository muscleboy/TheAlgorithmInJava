package xyz.bugcoder.DesignPattern.structure.adapter.normal;

import com.alibaba.fastjson.JSON;
import xyz.bugcoder.DesignPattern.structure.adapter.mq.OrderMq;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:23
 */
public class OrderMqService {

    public void onMessage(String message){

        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        mq.getUid();
        mq.getSku();
        mq.getOrderId();
        mq.getCreateOrderTime();

    }

}
