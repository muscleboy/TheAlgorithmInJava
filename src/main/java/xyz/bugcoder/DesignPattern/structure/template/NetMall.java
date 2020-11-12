package xyz.bugcoder.DesignPattern.structure.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.template
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 15:04
 */
// 模版模式在定义统⼀结构也就是执⾏标准上⾮常⽅便，后续的实现者不⽤关⼼调⽤逻辑，按照统⼀⽅式执⾏。那么类的继承者只需要关⼼具体的业务逻辑实现即可。
public abstract class NetMall {

    protected Logger logger = LoggerFactory.getLogger(NetMall.class);

    String uId;
    String pwd;

    public NetMall(String uId, String pwd) {
        this.uId = uId;
        this.pwd = pwd;
    }

    // 模拟登录
    protected abstract boolean login(String uId, String pwd);

    // 爬⾍提取商品信息(登录后的优惠价格)
    protected abstract Map<String, String> reptile(String url);

    // ⽣成商品海报信息
    protected abstract String createBase64(Map<String, String> goodsInfo);

    // ⽣成商品推⼴海报

    // 公⽤代码，⾏为由⽗类管理，扩展可变部分，也就⾮ 常有利于开发拓展和迭代。
    protected String genGoodsPoster(String url){
        if (!login(uId, pwd))
            return null;
        Map<String, String> map = reptile(url);
        return createBase64(map);
    }

}
