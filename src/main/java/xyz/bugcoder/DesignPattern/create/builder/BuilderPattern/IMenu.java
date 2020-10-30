package xyz.bugcoder.DesignPattern.create.builder.BuilderPattern;

import xyz.bugcoder.DesignPattern.create.builder.ifelse.Matter;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder.BuilderPattern
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-30 17:20
 */
public interface IMenu {

    // 吊顶
    IMenu appendCeiling(Matter matter);

    // 涂料
    IMenu appendCoat(Matter matter);

    // 地板
    IMenu appendFloor(Matter matter);

    // 地砖
    IMenu appendTile(Matter matter);

    // 明细
    String getDetail();

}
