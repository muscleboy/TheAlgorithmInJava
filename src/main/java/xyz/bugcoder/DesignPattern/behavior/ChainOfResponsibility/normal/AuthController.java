package xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal;

import java.text.ParseException;
import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 15:12
 */
public class AuthController {

    public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {

        // 三级审批
        Date date = AuthService.queryAuthInfo("1000013", orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", "王工");
        }

        // 二级审批
        date = AuthService.queryAuthInfo("1000012", orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", "张经理");
        }

        // 一级审批
        date = AuthService.queryAuthInfo("1000011", orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", "段总");
        }

        return new AuthInfo("0001", "单号：", orderId, " 状态：审批完成");
    }

}
