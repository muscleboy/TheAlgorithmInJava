package xyz.bugcoder.kuang.factory.abs;

/**
 * @Package: xyz.bugcoder.kuang.factory.abs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 22:00
 */
public class Client {
    // 抽象工厂模式
    // 定义：抽象工厂模式提供了一个创建一系列相关或相互依赖的对象的接口，无需指定具体的类
    // 适用场景
    //    客户端不依赖与产品实现类的如何被创建、实现等细节
    //    强调一系列相关的产品对象(属于同一产品族) 一起创建时需要大量重复的代码
    //    提供一个产品类的库，所有的产品以同样的接口出现，从而使得客户端不依赖于具体的实现
    // 优点
    //    具体产品在应用层的代码隔离，无需关系创建细节
    //    将一些列的产品统一到一起创建
    // 缺点
    //    规定了所有可能被创建的产品集，从产品族中拓展新品困难
    //    增加了系统的抽象性和理解难度
    public static void main(String[] args){
        System.out.println("==============小米产品============");
        IProductFactory xiaomiFactory = new XiaomiFactory();
        IPhoneProduct phone = xiaomiFactory.productPhone();
        phone.start();
        phone.shutdown();
        phone.call();
        phone.msg();
        IRouterProduct router = xiaomiFactory.productRouter();
        router.start();
        router.shutdown();
        router.openWifi();
        router.setWifi();

        System.out.println("==============华为产品============");
        IProductFactory huaweiFactory = new HuaweiFactory();
        phone = huaweiFactory.productPhone();
        phone.start();
        phone.shutdown();
        phone.call();
        phone.msg();
        router = huaweiFactory.productRouter();
        router.start();
        router.shutdown();
        router.openWifi();
        router.setWifi();

    }
}
