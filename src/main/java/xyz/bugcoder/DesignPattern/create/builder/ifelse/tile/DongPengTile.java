package xyz.bugcoder.DesignPattern.create.builder.ifelse.tile;

import xyz.bugcoder.DesignPattern.create.builder.ifelse.Matter;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.ifelse.tile
 * @author: Weiyj
 * @Description: 地砖
 * @createTime 2020-10-30 16:57
 */
public class DongPengTile implements Matter {

    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "东鹏瓷砖";
    }

    @Override
    public String model() {
        return "10001";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(102);
    }

    @Override
    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，⼝碑传播品牌为宗旨，2014年品牌 价值132.35亿元，位列建陶⾏业榜⾸。";
    }

}
