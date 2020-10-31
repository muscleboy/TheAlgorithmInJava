package xyz.bugcoder.DesignPattern.structure.adapter.normal;

import com.alibaba.fastjson.JSON;
import xyz.bugcoder.DesignPattern.structure.adapter.mq.CreateAccount;
/**
 * @Package: xyz.bugcoder.DesignPattern.structure
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:20
 */
public class CreateAccountMqService {

    public void onMessage(String message){

        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);

        mq.getNumber();
        mq.getAccountDate();
        mq.getAddress();
        mq.getDesc();

    }

}
