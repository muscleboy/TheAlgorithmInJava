package xyz.bugcoder.kuang.factory.abs;

/**
 * @Package: xyz.bugcoder.kuang.factory.abs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 21:57
 */
// 华为工厂生产华为的产品，如华为手机、华为路由器
public class HuaweiFactory implements IProductFactory {
    @Override
    public IPhoneProduct productPhone() {
        return new HuaweiPhone();
    }

    @Override
    public IRouterProduct productRouter() {
        return new HuaweiRouter() ;
    }
}
