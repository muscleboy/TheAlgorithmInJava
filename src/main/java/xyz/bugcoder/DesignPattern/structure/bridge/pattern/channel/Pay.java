package xyz.bugcoder.DesignPattern.structure.bridge.pattern.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.bridge.pattern.channel
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 15:10
 */
public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
