package xyz.bugcoder.DesignPattern.structure.decoration.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.structure.decoration.HandlerInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.decoration.pattern
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 17:35
 */

// 在装饰类中有两个重点的地⽅是；
//  1)继承了处理接⼝、
//  2)提供了构造函数、
//  3)覆盖了⽅法 preHandle 。
// 以上三个点是装饰器模式的核⼼处理部分，这样可以踢掉对⼦类继承的⽅式实现逻辑功能扩展。
public class LoginSsoDecorator extends SsoDecorator {

    private Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {

        boolean success = super.preHandle(request, response, handler);

        if (!success){
            return false;
        }

        String uId = request.substring(8);
        String method = authMap.get(uId);
        logger.info("模拟单点登录⽅法访问拦截校验：{} {}", uId, method);

        return "queryUserInfo".equals(method);

    }

}
