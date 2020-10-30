package xyz.bugcoder.DesignPattern.create.builder.BuilderPattern;

import xyz.bugcoder.DesignPattern.create.builder.ifelse.ceiling.LevelOneCeiling;
import xyz.bugcoder.DesignPattern.create.builder.ifelse.ceiling.LevelTwoCeiling;
import xyz.bugcoder.DesignPattern.create.builder.ifelse.coat.DuluxCoat;
import xyz.bugcoder.DesignPattern.create.builder.ifelse.coat.LiBangCoat;
import xyz.bugcoder.DesignPattern.create.builder.ifelse.floor.ShengXiangFloor;
import xyz.bugcoder.DesignPattern.create.builder.ifelse.tile.DongPengTile;
import xyz.bugcoder.DesignPattern.create.builder.ifelse.tile.MarcoPoloTile;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.BuilderPattern
 * @author: Weiyj
 * @Description: 建造者模式
 * @createTime 2020-10-30 17:25
 */

// 当： ⼀些基本物料不会变，⽽其组合经常变化的时候 ，就可以选择这样的设计模式来构建代码。
// 此设计模式满⾜了单⼀职责原则以及可复⽤的技术、建造者独⽴、易扩展、便于控制细节⻛风险。
//  但 同时当出现特别多的物料以及很多的组合后，类的不断扩展也会造成难以维护的问题。
//  但这种设计 结构模型可以把重复的内容抽象到数据库中，按照需要配置。这样就可以减少代码中⼤量的重复。
//
public class Builder {

    public IMenu levelOne(BigDecimal area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                // 吊顶，⼆级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，多乐⼠
                .appendCoat(new DuluxCoat())
                // 地板，圣象
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(BigDecimal area) {
        return new DecorationPackageMenu(area, "轻奢⽥园")
                // 吊顶，⼆级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，⽴邦
                .appendCoat(new LiBangCoat())
                // 地砖，⻢马可波罗
                .appendTile(new MarcoPoloTile());
    }

    public IMenu levelThree(BigDecimal area) {
        return new DecorationPackageMenu(area, "现代简约")
                // 吊顶，⼆级顶
                .appendCeiling(new LevelOneCeiling())
                // 涂料，⽴邦
                .appendCoat(new LiBangCoat())
                // 地砖，东鹏
                .appendTile(new DongPengTile());
    }

}
