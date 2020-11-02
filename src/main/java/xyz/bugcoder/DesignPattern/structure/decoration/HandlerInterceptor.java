package xyz.bugcoder.DesignPattern.structure.decoration;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.decoration
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 17:11
 */
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
