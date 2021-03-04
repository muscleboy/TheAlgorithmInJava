package xyz.bugcoder.kuang.factory.abs;

/**
 * @Package: xyz.bugcoder.kuang.factory.abs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 21:52
 */
// 小米路由器
public class XiaomiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("开启小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("开启小米路由器WiFi");
    }

    @Override
    public void setWifi() {
        System.out.println("设置小米路由器WiFi");
    }
}
