package xyz.bugcoder.DesignPattern.structure.flyweight;

import lombok.Data;

import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.flyweight
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 16:54
 */
@Data
public class Activity {

    private Long id;        // 活动ID
    private String name;    // 活动名称
    private String desc;    // 活动描述
    private Date startTime; // 开始时间
    private Date stopTime;  // 结束时间
    private Stock stock;    // 活动库存


}
