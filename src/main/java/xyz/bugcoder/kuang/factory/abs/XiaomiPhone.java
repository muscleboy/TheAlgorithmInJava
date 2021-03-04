package xyz.bugcoder.kuang.factory.abs;

/**
 * @Package: xyz.bugcoder.kuang.factory.abs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 21:50
 */
// 小米手机
public class XiaomiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void msg() {
        System.out.println("小米手机发信息");
    }
}
