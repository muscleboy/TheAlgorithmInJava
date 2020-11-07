package xyz.bugcoder.DesignPattern.behavior.command.normal;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.command.normal
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 17:04
 */

public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private Map<Integer, String> cuisineMap = new ConcurrentHashMap<Integer, String>();

//    点单添加菜品
    public void order(int cuisine) {
        if (1 == cuisine) {
            cuisineMap.put(1, "⼴东厨师，烹饪鲁菜，宫廷最⼤菜系，以孔府⻛风味为⻰龙 头");
        }
        if (2 == cuisine) {
            cuisineMap.put(2, "江苏厨师，烹饪苏菜，宫廷第⼆⼤菜系，古今国宴上最受⼈ 欢迎的菜系。");
        }
        if (3 == cuisine) {
            cuisineMap.put(3, "⼭东厨师，烹饪鲁菜，宫廷最⼤菜系，以孔府⻛风味为⻰龙头.");
        }
        if (4 == cuisine) {
            cuisineMap.put(4, "四川厨师，烹饪川菜，中国最有特⾊的菜系，也是⺠民间最⼤ 菜系。");
        }
    }

//    展示菜 品的信息
    public void placeOrder() {
        logger.info("菜单：{}", JSON.toJSONString(cuisineMap));
    }

}
