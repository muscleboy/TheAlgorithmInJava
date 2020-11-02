package xyz.bugcoder.DesignPattern.structure.decoration;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.decoration
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 17:11
 */
public class SsoInterceptor implements HandlerInterceptor {

    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }

}
