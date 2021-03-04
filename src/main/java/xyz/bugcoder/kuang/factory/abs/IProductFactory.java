package xyz.bugcoder.kuang.factory.abs;

/**
 * @Package: xyz.bugcoder.kuang.factory.abs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 21:55
 */
// 抽象产品工厂 (工厂的工厂)
public interface IProductFactory {

    // 生产手机
    IPhoneProduct productPhone();

    // 生产路由器
    IRouterProduct productRouter();

}
