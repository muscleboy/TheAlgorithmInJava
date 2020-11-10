package xyz.bugcoder.DesignPattern.structure.strategy;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.strategy
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 16:46
 */
public interface ICouponDiscount<T> {

    /** *
     * 优惠券⾦额计算
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param price sku⾦额
     * @return 优惠后⾦额
    */
    BigDecimal discount(T couponInfo, BigDecimal price);

}
