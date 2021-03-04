package xyz.bugcoder.kuang.factory.abs;

/**
 * @Package: xyz.bugcoder.kuang.factory.abs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 21:47
 */
// 路由器产品
public interface IRouterProduct {

    void start();
    void shutdown();
    void openWifi();
    void setWifi();

}
