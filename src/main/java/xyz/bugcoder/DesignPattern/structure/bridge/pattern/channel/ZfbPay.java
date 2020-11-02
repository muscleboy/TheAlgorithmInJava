package xyz.bugcoder.DesignPattern.structure.bridge.pattern.channel;

import xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.bridge.pattern.channel
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 15:15
 */
public class ZfbPay extends Pay {

    public ZfbPay(IPayMode iPayMode) {
        super(iPayMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟⽀付宝渠道⽀付划账开始。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("模拟⽀付宝渠道⽀付⻛风控校验。uId：{} tradeId：{} security： {}", uId, tradeId, security);
        if (!security) {
            logger.info("模拟⽀付宝渠道⽀付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟⽀付宝渠道⽀付划账成功。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
        return "0000";
    }

}
