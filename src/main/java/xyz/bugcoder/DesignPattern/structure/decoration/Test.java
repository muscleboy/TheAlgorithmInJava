package xyz.bugcoder.DesignPattern.structure.decoration;

import xyz.bugcoder.DesignPattern.structure.decoration.normal.LoginSsoDecorator;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.decoration
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 17:15
 */
public class Test {

    @org.junit.Test
    public void test(){

        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator();

        String request = "1successhuahua";

        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");

        System.out.println("登录校验：" + request + (success ? " 放⾏" : " 拦 截"));

    }

    @org.junit.Test
    public void test2(){

        // 通过透传原有单点登录类 new SsoInterceptor() ，传递给装饰器，让装饰器可以执⾏扩充的功能。
        xyz.bugcoder.DesignPattern.structure.decoration.pattern.LoginSsoDecorator ssoDecorator =
                new xyz.bugcoder.DesignPattern.structure.decoration.pattern.LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";

        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");

        System.out.println("登录校验：" + request + (success ? " 放⾏" : " 拦 截"));

    }

}
