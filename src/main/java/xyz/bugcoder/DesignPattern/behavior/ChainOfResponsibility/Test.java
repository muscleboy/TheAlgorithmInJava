package xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal.AuthController;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal.AuthService;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern.AuthLink;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern.impl.Level1AuthLink;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern.impl.Level2AuthLink;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern.impl.Level3AuthLink;

import java.text.ParseException;
import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 15:21
 */
public class Test {

    private Logger logger = LoggerFactory.getLogger("Test");

    @org.junit.Test
    public void test() throws ParseException {

        AuthController authController = new AuthController();

        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("⼩ 傅哥", "1000998004813441", new Date())));
        logger.info("测试结果：{}", "模拟三级负责⼈审批，王⼯");
        AuthService.auth("1000013", "1000998004813441");

        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("⼩ 傅哥", "1000998004813441", new Date())));
        logger.info("测试结果：{}", "模拟⼆级负责⼈审批，张经理");
        AuthService.auth("1000012", "1000998004813441");

        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("⼩ 傅哥", "1000998004813441", new Date())));
        logger.info("测试结果：{}", "模拟⼀级负责⼈审批，段总");
        AuthService.auth("1000011", "1000998004813441");

        logger.info("审批完成！！！！");
    }

    @org.junit.Test
    public void test2() throws ParseException {

        // 这⾥包括最核⼼的责任链创建，实际的业务中会包装到控制层；
        //
        //AuthLink authLink = new Level3AuthLink("1000013", "王⼯").appendNext(new Level2AuthLink("1000012","张经理") .appendNext(new Level1AuthLink("1000011", "段总")));
        //
        //通过把不同的责任节
        //
        //点进⾏组装，构成⼀条完整业务的责任链。 接下⾥不断的执⾏查看审核链路 authLink.doAuth(...) ，通过返回结果对数据进⾏3、2、1级 负责⼈审核，直⾄最后审核全部完成。

        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("测试结果：{}", "模拟三级负责人审批，王工");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("测试结果：{}", "模拟二级负责人审批，张经理");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("测试结果：{}", "模拟一级负责人审批，段总");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        logger.info("审批完成！！！！");
    }

}
