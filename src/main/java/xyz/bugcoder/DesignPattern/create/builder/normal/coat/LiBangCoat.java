package xyz.bugcoder.DesignPattern.create.builder.normal.coat;

import xyz.bugcoder.DesignPattern.create.builder.normal.Matter;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.normal.coat
 * @author: Weiyj
 * @Description: 涂料-立邦
 * @createTime 2020-10-30 16:53
 */
public class LiBangCoat implements Matter {

    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "⽴邦";
    }

    @Override
    public String model() {
        return "默认级别";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(650);
    }

    @Override
    public String desc() {
        return "⽴邦始终以开发绿⾊产品、注重⾼科技、⾼品质为⽬标，以技术⼒量不断推进科 研和开发，满⾜消费者需求。";
    }

}
