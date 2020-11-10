package xyz.bugcoder.DesignPattern.structure.strategy.impl;

import xyz.bugcoder.DesignPattern.structure.strategy.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.strategy.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 16:48
 */
public class ZKDiscount implements ICouponDiscount<Double> {

    /**
     * 折扣计算
     *  打八折
     */
    @Override
    public BigDecimal discount(Double couponInfo, BigDecimal price) {

        // 打八折，四舍五入
        BigDecimal discount = price.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discount.compareTo(BigDecimal.ZERO) < 1)
            return BigDecimal.ONE;

        return discount;
    }

}
