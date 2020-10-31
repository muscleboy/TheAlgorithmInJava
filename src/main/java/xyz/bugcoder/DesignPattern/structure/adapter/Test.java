package xyz.bugcoder.DesignPattern.structure.adapter;

import com.alibaba.fastjson.JSON;
import xyz.bugcoder.DesignPattern.structure.adapter.normal.impl.InsideOrderServiceImpl;
import xyz.bugcoder.DesignPattern.structure.adapter.normal.impl.POPOrderAdapterServiceImpl;
import xyz.bugcoder.DesignPattern.structure.adapter.mq.CreateAccount;
import xyz.bugcoder.DesignPattern.structure.adapter.mq.OrderMq;
import xyz.bugcoder.DesignPattern.structure.adapter.pattern.MQAdapter;
import xyz.bugcoder.DesignPattern.structure.adapter.pattern.RebateInfo;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:34
 */
public class Test {

    @org.junit.Test
    public void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2020-06-01 23:20:16");


        CreateAccount create_account = new CreateAccount();
        create_account.setNumber("100001");
        create_account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        create_account.setAccountDate(parse);
        create_account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(create_account.toString(), link01);
        System.out.println("mq.create_account(适配前)" + create_account.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println();

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(parse);

        HashMap<String, String> link02 = new HashMap<>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }

    @org.junit.Test
    public void test_itfAdapter() {
        POPOrderAdapterServiceImpl popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        InsideOrderServiceImpl insideOrderService = new InsideOrderServiceImpl();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }

}
