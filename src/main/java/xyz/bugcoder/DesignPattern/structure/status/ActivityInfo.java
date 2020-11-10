package xyz.bugcoder.DesignPattern.structure.status;

import lombok.Data;

import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.status
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 15:02
 */
@Data
public class ActivityInfo {

    private String activityId;
    private String activityName;
    private Enum<Status> status;
    private Date beginTime;
    private Date endTime;

}
