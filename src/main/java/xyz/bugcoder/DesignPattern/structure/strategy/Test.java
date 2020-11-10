package xyz.bugcoder.DesignPattern.structure.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.structure.strategy.impl.MJDiscount;
import xyz.bugcoder.DesignPattern.structure.strategy.impl.NYGDiscount;
import xyz.bugcoder.DesignPattern.structure.strategy.impl.ZJDiscount;
import xyz.bugcoder.DesignPattern.structure.strategy.impl.ZKDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.strategy
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 17:01
 */
public class Test {

    private Logger logger = LoggerFactory.getLogger("Test");

    @org.junit.Test
    public void test(){
        Context context = new Context(new MJDiscount());
        Map<String, String> map = new HashMap<>();
        map.put("x", "100");
        map.put("o", "9.8");
        BigDecimal discount = context.discount(map, new BigDecimal(100));

        logger.info("满减后: " + discount);
    }

    @org.junit.Test
    public void test_plus() {
        // 所有优惠叠加，直减、满减、折扣、n元购
        Context<Double> zj = new Context<Double>(new ZJDiscount());
        Context<Map<String,String>> mj = new Context<Map<String,String>>(new MJDiscount());
        Map<String,String> mapReq = new HashMap<String, String>();
        mapReq.put("x","90");
        mapReq.put("o","10");
        Context<Double> zk = new Context<Double>(new ZKDiscount());
        Context<Double> nyg = new Context<Double>(new NYGDiscount());
        BigDecimal zjhou = zj.discount(10D, new BigDecimal(100));
        logger.info("测试结果：直减优惠后金额 {}", zjhou);
        BigDecimal mjhou = mj.discount(mapReq, zjhou);
        logger.info("测试结果：满减优惠后金额 {}", mjhou);
        BigDecimal zkhou = zk.discount(0.9D, mjhou);
        logger.info("测试结果：折扣优惠后金额 {}", zkhou);
        BigDecimal nyghou = nyg.discount(70D, zkhou);
        logger.info("测试结果：n元购优惠后金额 {}", nyghou);
    }

}
