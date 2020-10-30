package xyz.bugcoder.DesignPattern.create.builder.ifelse.ceiling;

import xyz.bugcoder.DesignPattern.create.builder.ifelse.Matter;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.ifelse.ceiling
 * @author: Weiyj
 * @Description: 二级顶
 * @createTime 2020-10-30 16:51
 */
public class LevelTwoCeiling implements Matter {

    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司⾃带";
    }

    @Override
    public String model() {
        return "二级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    @Override
    public String desc() {
        return "两个层次的吊顶，⼆级吊顶⾼度⼀般就往下吊20cm，要是层⾼很⾼，也可增加 每级的厚度";
    }

}
