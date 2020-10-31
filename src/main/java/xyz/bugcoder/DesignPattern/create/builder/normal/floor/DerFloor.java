package xyz.bugcoder.DesignPattern.create.builder.normal.floor;

import xyz.bugcoder.DesignPattern.create.builder.normal.Matter;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.normal.coat
 * @author: Weiyj
 * @Description: 地板-德尔
 * @createTime 2020-10-30 16:53
 */
public class DerFloor implements Matter {

    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "德尔";
    }

    @Override
    public String model() {
        return "A+";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(119);
    }

    @Override
    public String desc() {
        return "DER德尔集团是全球领先的专业⽊地板制造商，北京2008年奥运会家装和公装 地板供应商";
    }

}
