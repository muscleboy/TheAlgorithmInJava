package xyz.bugcoder.DesignPattern.structure.proxy.agent;

import java.lang.annotation.*;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.proxy.agent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 18:03
 */
// 准备工作1
// 定义⼀个模拟mybatis-spring中的⾃定义注解，⽤于使⽤在⽅法层⾯。

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {

    // select sql语句
    String value() default "";

}
