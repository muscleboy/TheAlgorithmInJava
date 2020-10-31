package xyz.bugcoder.DesignPattern.create.factorymethod;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.factorymethod
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-29 15:19
 */
public class Factory2 extends Factory {

    @Override
    Product2 factoryMethod() {
        System.out.println("factoryMethod Factory2");
        return new Product2();
    }

}
