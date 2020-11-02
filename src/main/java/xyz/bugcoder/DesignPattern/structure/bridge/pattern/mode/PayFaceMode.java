package xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 15:21
 */
public class PayFaceMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayFaceMode.class);

    public boolean security(String uId) {
        logger.info("⼈脸⽀付，⻛风控校验脸部识别");
        return true;
    }

}
