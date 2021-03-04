package xyz.bugcoder.kuang.factory.simple;

/**
 * @Package: xyz.bugcoder.kuang.factory.simple
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 20:55
 */
public class CarFactory {

    // 不好的地方
    //   每增加一个品类的话，就需要修改这个方法，不符合 OCP (拓展开放，修改关闭) 原则
    public Car getCar(String name) {
        if (name.equals("wuling")) {
            return new Wuling();
        } else if (name.equals("civis")) {
            return new Civis();
        }
        return null;
    }

}
