package xyz.bugcoder.DesignPattern.structure.normal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.normal.service
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:07
 */
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId) {
        logger.info("⾃营商家，查询⽤户的订单是否为⾸单：{}", userId);
        return 10L;
    }

}
