package xyz.bugcoder.DesignPattern.structure.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.proxy
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 19:25
 */
// 代理模式的设计⽅式可以让代码更加整洁、⼲净易于维护，虽然在这部分开发中额外增加了很多类,
// 也包括了⾃⼰处理bean的注册等，但是这样的中间件复⽤性极⾼也更加智能，可以⾮常⽅便的扩 展到各个服务应⽤中。
public class Test {

    private Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public void test(){

        // 通过加载Bean⼯⼚获取我们的代理类的实例对象
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String userInfo = userDao.queryUserInfo("100001");
        logger.info("result: " + userInfo);

    }

}
