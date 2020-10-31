package xyz.bugcoder.DesignPattern.structure.adapter.normal.impl;

import xyz.bugcoder.DesignPattern.structure.adapter.normal.OrderAdapterService;
import xyz.bugcoder.DesignPattern.structure.adapter.normal.service.OrderService;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.adapter.normal.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 17:15
 */
public class InsideOrderServiceImpl implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
