package xyz.bugcoder.kuang.factory.abs;

/**
 * @Package: xyz.bugcoder.kuang.factory.abs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 21:57
 */
// 小米工厂生产小米的产品，如小米手机、小米路由器
public class XiaomiFactory implements IProductFactory {
    @Override
    public IPhoneProduct productPhone() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct productRouter() {
        return new XiaomiRouter();
    }
}
