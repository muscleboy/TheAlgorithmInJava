package xyz.bugcoder.kuang.factory.method;

/**
 * @Package: xyz.bugcoder.kuang.factory.simple
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 20:55
 */
// 工厂方法模式 -- 虽然每增加一个车型，不需要修改原来的代码，
// 但是造成代码量增多，都需要一个具体车型的工厂
public interface CarFactory {

    Car getCar();

}
