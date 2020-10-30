package xyz.bugcoder.DesignPattern.create.builder.ifelse.coat;

import xyz.bugcoder.DesignPattern.create.builder.ifelse.Matter;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.ifelse.coat
 * @author: Weiyj
 * @Description: 涂料-多乐士
 * @createTime 2020-10-30 16:52
 */
public class DuluxCoat implements Matter {

    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "多乐⼠(Dulux)";
    }

    @Override
    public String model() {
        return "第⼆代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(719);
    }

    @Override
    public String desc() {
        return "多乐⼠是阿克苏诺⻉贝尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100个国 家，每年全球有5000万户家庭使⽤多乐⼠油漆。";
    }

}
