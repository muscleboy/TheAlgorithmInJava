package xyz.bugcoder.DesignPattern.create.builder.normal;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder
 * @author: Weiyj
 * @Description: 建造者模式-装修工程
 * @createTime 2020-10-30 16:44
 */
public interface Matter {

    // 场景；地板、地砖、涂料、吊顶
    String scene();

    // 品牌
    String brand();

    // 型号
    String model();

    // 价格
    BigDecimal price();

    // 描述
    String desc();

}
