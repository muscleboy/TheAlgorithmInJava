package xyz.bugcoder.DesignPattern.structure.bridge;

import xyz.bugcoder.DesignPattern.structure.bridge.normal.PayController;
import xyz.bugcoder.DesignPattern.structure.bridge.pattern.channel.Pay;
import xyz.bugcoder.DesignPattern.structure.bridge.pattern.channel.WxPay;
import xyz.bugcoder.DesignPattern.structure.bridge.pattern.channel.ZfbPay;
import xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode.PayFaceMode;
import xyz.bugcoder.DesignPattern.structure.bridge.pattern.mode.PayFingerprintMode;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.bridge
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 14:59
 */
public class Test {

    @org.junit.Test
    public void test(){

        PayController pay = new PayController();

        System.out.println("\r\n模拟测试场景；微信⽀付、⼈脸⽅式。");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；⽀付宝⽀付、指纹⽅式。");
        pay.doPay("jlu19dlxo111","100000109894",new BigDecimal(100), 2, 3);

    }

    @org.junit.Test
    public void test2(){

        System.out.println("\r\n模拟测试场景；微信⽀付、⼈脸⽅式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("=============================");

        System.out.println("\r\n模拟测试场景；支付宝⽀付、指纹⽅式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(1001));

    }

}
