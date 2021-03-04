package xyz.bugcoder.kuang.factory.method;

/**
 * @Package: xyz.bugcoder.kuang.factory.method.simple
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 21:08
 */
public class CivisFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Civis();
    }
}
