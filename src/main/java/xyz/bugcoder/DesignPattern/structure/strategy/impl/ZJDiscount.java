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
public class ZJDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使⽤商品价格减去优惠价格
     * 2. 最低⽀付⾦额1元
     */
    @Override
    public BigDecimal discount(Double couponInfo, BigDecimal price) {

        // 直减计算
        BigDecimal discount = price.subtract(new BigDecimal(couponInfo));
        if (discount.compareTo(BigDecimal.ZERO) < 1)
            return BigDecimal.ONE;

        return discount;
    }

}
