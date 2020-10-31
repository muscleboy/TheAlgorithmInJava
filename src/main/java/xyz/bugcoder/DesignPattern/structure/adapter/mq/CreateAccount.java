package xyz.bugcoder.DesignPattern.structure.adapter.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.adapter.mq
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 16:04
 */
@Data
public class CreateAccount {

    // 开户编号
    private String number;
    // 开户地址
    private String address;
    // 开户时间
    private Date accountDate;
    // 开户描述
    private String desc;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
