package xyz.bugcoder.DesignPattern.structure.decoration.pattern;

import xyz.bugcoder.DesignPattern.structure.decoration.HandlerInterceptor;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.decoration.pattern
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 17:31
 */

// 在装饰器模式中有四个⽐较重要点抽象出来的点；
// 1.抽象构件⻆角⾊(Component) - 定义抽象接⼝                        (HandlerInterceptor)
// 2.具体构件⻆角⾊(ConcreteComponent) - 实现抽象接⼝，可以是⼀组      (SsoInterceptor)
// 3.装饰⻆角⾊(Decorator) - 定义抽象类并继承接⼝中的⽅法，保证⼀致性    (SsoDecorator)
// 4.具体装饰⻆角⾊(ConcreteDecorator) - 扩展装饰具体的实现逻辑        (LoginSsoDecorator)
public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    public SsoDecorator() {
    }

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }

}
