package xyz.bugcoder.DesignPattern.structure.adapter.normal.impl;

import xyz.bugcoder.DesignPattern.structure.adapter.normal.OrderAdapterService;
import xyz.bugcoder.DesignPattern.structure.adapter.normal.service.POPOrderService;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.adapter.normal.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 17:16
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
