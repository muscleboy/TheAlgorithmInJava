package xyz.bugcoder.DesignPattern.iterator.group;

import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.iterator.group
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-08 15:09
 */
@Data
public class Employee {

    private String uId;   // ID
    private String name;  // 名字
    private String desc;  // 备注

    public Employee(String uId, String name, String desc) {
        this.uId = uId;
        this.name = name;
        this.desc = desc;
    }
}
