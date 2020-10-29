package xyz.bugcoder.DesignPattern.pattern.factorymethod;

/**
 * @Package: xyz.bugcoder.DesignPattern.pattern.factorymethod
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-29 15:19
 */
public class Factory1 extends Factory {

    @Override
    Product1 factoryMethod() {
        System.out.println("factoryMethod Factory1");
        return new Product1();
    }

}
