package xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern.impl;

import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal.AuthInfo;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal.AuthService;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern.AuthLink;

import java.text.ParseException;
import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 15:50
 */
public class Level3AuthLink extends AuthLink {

    private Date beginDate = f.parse("2020-11-01 00:00:00");
    private Date endDate = f.parse("2020-11-25 23:59:59");

    public Level3AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0003", "单号：", orderId, " 状态：待三级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("000033", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000333", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
