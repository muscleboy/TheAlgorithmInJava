package xyz.bugcoder.DesignPattern.structure.adapter.normal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.adapter.normal.service
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:11
 */
public class POPOrderService {

    private Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uId) {
        logger.info("POP商家，查询⽤户的订单是否为⾸单：{}", uId);
        return true;
    }

}
