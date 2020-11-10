package xyz.bugcoder.DesignPattern.structure.strategy;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.strategy
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 17:02
 */

// 统一的方法进行优惠计算
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discount(T couponInfo, BigDecimal price){
        return couponDiscount.discount(couponInfo, price);
    }
}
