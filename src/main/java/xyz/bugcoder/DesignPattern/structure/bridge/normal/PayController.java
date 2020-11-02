package xyz.bugcoder.DesignPattern.structure.bridge.normal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.bridge.normal
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 14:54
 */
public class PayController {

    private Logger logger = LoggerFactory.getLogger(PayController.class);

    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {

        // 微信⽀付
        if (1 == channelType) {
            logger.info("模拟微信渠道⽀付划账开始。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
            if (1 == modeType) {
                logger.info("密码⽀付，⻛风控校验环境安全");
            } else if (2 == modeType) {
                logger.info("⼈脸⽀付，⻛风控校验脸部识别");
            } else if (3 == modeType) {
                logger.info("指纹⽀付，⻛风控校验指纹信息");
            }
        }

        // ⽀付宝⽀付
        else if (2 == channelType) {
            logger.info("模拟⽀付宝渠道⽀付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                logger.info("密码⽀付，⻛风控校验环境安全");
            } else if (2 == modeType) {
                logger.info("⼈脸⽀付，⻛风控校验脸部识别");
            } else if (3 == modeType) {
                logger.info("指纹⽀付，⻛风控校验指纹信息");
            }

        }

        return true;
    }
}
