package xyz.bugcoder.DesignPattern.structure.strategy.impl;

import xyz.bugcoder.DesignPattern.structure.strategy.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.strategy.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 16:48
 */
public class NYGDiscount implements ICouponDiscount<Double> {

    /**
     * N元购
     * 1. ⽆论原价多少钱都固定⾦额购买
     */
    @Override
    public BigDecimal discount(Double couponInfo, BigDecimal price) {

        return new BigDecimal(couponInfo);
    }

}
