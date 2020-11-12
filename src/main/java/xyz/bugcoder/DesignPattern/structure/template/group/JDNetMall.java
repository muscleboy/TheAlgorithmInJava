package xyz.bugcoder.DesignPattern.structure.template.group;

import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Encoder;
import xyz.bugcoder.DesignPattern.structure.template.HttpClient;
import xyz.bugcoder.DesignPattern.structure.template.NetMall;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.template.group
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 15:04
 */
public class JDNetMall extends NetMall {

    public JDNetMall(String uId, String pwd) {
        super(uId, pwd);
    }

    @Override
    protected boolean login(String uId, String pwd) {
        logger.info("模拟JingDong⽤户登录 uId：{} uPwd：{}", uId, pwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String url) {
        String str = HttpClient.get(url);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "5999.00");
        logger.info("模拟京东商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), url);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("模拟⽣成京东商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}
