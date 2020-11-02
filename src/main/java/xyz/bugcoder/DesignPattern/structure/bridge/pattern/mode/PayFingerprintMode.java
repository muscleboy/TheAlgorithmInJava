package xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 15:21
 */
public class PayFingerprintMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayFingerprintMode.class);

    public boolean security(String uId) {
        logger.info("指纹⽀付，⻛风控校验指纹信息");
        return true;
    }

}
