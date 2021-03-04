package xyz.bugcoder.kuang.factory.simple;

/**
 * @Package: xyz.bugcoder.kuang.factory.simple
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 20:54
 */
public class Consumer {

    public static void main(String[] args) {
        // 1. 原始的方式
//        Car wuling = new Wuling();
//        Car civis = new Civis();
//        wuling.name();
//        civis.name();


        // 2. 通过简单工厂模式
        // 将使用者和提供者解耦，借助第三方(工厂)来实现，
        // 现在就只需要告诉工厂，需要什么款式的车，就可以了，并不需要去管车是怎么来的
        CarFactory factory = new CarFactory();
        Car wuling = factory.getCar("wuling");
        Car civis = factory.getCar("civis");
        wuling.name();
        civis.name();
    }

}
