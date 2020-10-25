package xyz.bugcoder.DesignPattern.pattern.factory;

/**
 * @Package: xyz.bugcoder.DesignPattern.pattern.factory
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-25 17:16
 */
public class Client {

    public static void main(String[] args) {

        SimpleFactory factory = new SimpleFactory();
        factory.createProduct(1).show();
        factory.createProduct(2).show();
        factory.createProduct(3).show();
    }

}
