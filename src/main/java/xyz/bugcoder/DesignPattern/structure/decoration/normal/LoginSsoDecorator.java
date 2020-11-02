package xyz.bugcoder.DesignPattern.structure.decoration.normal;

import xyz.bugcoder.DesignPattern.structure.decoration.SsoInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.decoration
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 17:13
 */
public class LoginSsoDecorator extends SsoInterceptor {

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        boolean success = ticket.equals("success");

        if (!success) return false;

        String userId = request.substring(8);
        String method = authMap.get(userId);

        // 模拟⽅法校验
        return "queryUserInfo".equals(method);

    }

}
