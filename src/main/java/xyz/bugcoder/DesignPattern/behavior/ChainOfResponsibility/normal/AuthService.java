package xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 15:03
 */
// 责任链模式的核⼼是解决⼀组服务中的先后执⾏处理关系，就有点像你没钱花了，需要家庭财务⽀出审 批，
// 10块钱以下找闺⼥审批，100块钱先闺⼥审批在媳妇审批。你可以理解想象成当你要跳槽的时候被 安排的明明⽩⽩的被各个领导签字放⾏。
public class AuthService {

    // 这⾥⾯提供了两个接⼝⼀个是查询审核结果( queryAuthInfo )、另外⼀个是处理审核( auth )。
    // 这部分是把由谁审核的和审核的单⼦ID作为唯⼀key值记录到内存Map结构中。
    private static Map<String, Date> authMap = new ConcurrentHashMap<>();

    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }

}
