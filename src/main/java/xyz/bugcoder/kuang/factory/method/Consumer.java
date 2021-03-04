package xyz.bugcoder.kuang.factory.method;

/**
 * @Package: xyz.bugcoder.kuang.factory.simple
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 20:54
 */
public class Consumer {

    // 工厂方法模式，在不修改已有类的情况下，通过新增工厂类来实现拓展
    public static void main(String[] args) {
        Car wuling = new WulingFactory().getCar();
        Car civis = new CivisFactory().getCar();

        wuling.name();
        civis.name();
    }

}
