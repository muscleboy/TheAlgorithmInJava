package xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 15:21
 */
public class PayCypher implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("密码⽀付，⻛风控校验环境安全");
        return true;
    }

}
