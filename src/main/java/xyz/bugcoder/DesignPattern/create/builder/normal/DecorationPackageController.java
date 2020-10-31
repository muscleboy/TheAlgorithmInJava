package xyz.bugcoder.DesignPattern.create.builder.normal;

import xyz.bugcoder.DesignPattern.create.builder.normal.ceiling.LevelTwoCeiling;
import xyz.bugcoder.DesignPattern.create.builder.normal.coat.DuluxCoat;
import xyz.bugcoder.DesignPattern.create.builder.normal.coat.LiBangCoat;
import xyz.bugcoder.DesignPattern.create.builder.normal.floor.ShengXiangFloor;
import xyz.bugcoder.DesignPattern.create.builder.normal.tile.DongPengTile;
import xyz.bugcoder.DesignPattern.create.builder.normal.tile.MarcoPoloTile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-30 17:02
 */
public class DecorationPackageController {

    // 常规写法, if else大法
    public static String getMatterList(BigDecimal area, Integer level) {

        // 装修清单
        BigDecimal price = BigDecimal.ZERO;
        // 装修价格
        List<Matter> list = new ArrayList<Matter>();

        // 豪华欧式
        if(1 == level){

            // 吊顶，⼆级顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();

            // 涂料，多乐⼠
            DuluxCoat duluxCoat = new DuluxCoat();

            // 地板，圣象
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor();

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengXiangFloor.price()));
        }
        // 轻奢⽥园
        if (2 == level) {

            // 吊顶，⼆级顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();

            LiBangCoat liBangCoat = new LiBangCoat();

            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();

            // 涂料，⽴邦
            list.add(levelTwoCeiling); list.add(liBangCoat); list.add(marcoPoloTile);


            // 地砖，⻢马可波罗
            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));
        }

        // 现代简约
        if (3 == level) {

            // 吊顶，⼆级顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();

            LiBangCoat liBangCoat = new LiBangCoat();

            DongPengTile dongPengTile = new DongPengTile();

            // 涂料，⽴邦
            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);

            // 地砖，⻢马可波罗
            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }

        StringBuilder detail = new StringBuilder("\r\n------------------------------------------------------\r\n" + "装修清单" + "\r\n" + "套餐等级：" + level + "\r\n" + "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" + "房屋⾯积：" + area.doubleValue() + " 平⽶\r\n" + "材料清单：\r\n");

        for (Matter matter: list) {

            detail.append(matter.scene())
                    .append("：")
                    .append(matter.brand())
                    .append( "、")
                    .append(matter.model())
                    .append("、平⽶价 格：")
                    .append(matter.price())
                    .append(" 元。\n"); }

        return detail.toString();
    }

}
