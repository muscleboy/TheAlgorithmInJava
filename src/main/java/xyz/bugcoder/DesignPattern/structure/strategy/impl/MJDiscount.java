package xyz.bugcoder.DesignPattern.structure.strategy.impl;

import xyz.bugcoder.DesignPattern.structure.strategy.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.strategy.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 16:48
 */
public class MJDiscount implements ICouponDiscount<Map<String, String>> {

    @Override
    public BigDecimal discount(Map<String, String> couponInfo, BigDecimal price) {

        String x =  couponInfo.get("x");
        String o =  couponInfo.get("o");
        // 减去优惠⾦额判断
        if (price.compareTo(new BigDecimal(x)) < 0)
            return price;
        BigDecimal decimal = price.subtract(new BigDecimal(o));

        if (decimal.compareTo(BigDecimal.ZERO) < 1)
            return BigDecimal.ONE;

        return decimal;
    }

}
