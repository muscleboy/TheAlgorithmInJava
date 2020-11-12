package xyz.bugcoder.DesignPattern.structure.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.structure.template.group.DDNetMall;
import xyz.bugcoder.DesignPattern.structure.template.group.JDNetMall;
import xyz.bugcoder.DesignPattern.structure.template.group.TBNetMall;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.template
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 15:25
 */
public class Test {


    private Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public void test(){
        NetMall netMall = new DDNetMall("1001", "******");
        String base64 = netMall.genGoodsPoster("http://product.dangdang.com/1509704171.html");
        logger.info("测试结果：{}", base64);
    }

    @org.junit.Test
    public void test2(){
        NetMall netMall = new JDNetMall("1001", "******");
        String base64 = netMall.genGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }

    @org.junit.Test
    public void test3(){
        NetMall netMall = new TBNetMall("1001", "******");
        String base64 = netMall.genGoodsPoster("https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.51.38e87043Px7cUP&id=626776539938&skuId=4488596221991&areaId=440400&user_id=1714128138&cat_id=2&is_b=1&rn=8a60b19b34b4128df812e3f19ab71f91");
        logger.info("测试结果：{}", base64);
    }

}
