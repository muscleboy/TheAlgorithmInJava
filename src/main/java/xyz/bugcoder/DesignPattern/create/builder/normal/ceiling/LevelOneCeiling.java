package xyz.bugcoder.DesignPattern.create.builder.normal.ceiling;

import xyz.bugcoder.DesignPattern.create.builder.normal.Matter;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.normal.ceiling
 * @author: Weiyj
 * @Description: ⼀级顶
 * @createTime 2020-10-30 16:47
 */
public class LevelOneCeiling implements Matter {

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
        return "⼀级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(260);
    }

    @Override
    public String desc() {
        return "造型只做低⼀级，只有⼀个层次的吊顶，⼀般离顶120-150mm";
    }

}
