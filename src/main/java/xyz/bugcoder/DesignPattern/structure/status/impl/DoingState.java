package xyz.bugcoder.DesignPattern.structure.status.impl;


import xyz.bugcoder.DesignPattern.structure.status.ActivityService;
import xyz.bugcoder.DesignPattern.structure.status.Result;
import xyz.bugcoder.DesignPattern.structure.status.State;
import xyz.bugcoder.DesignPattern.structure.status.Status;

/**
 * 活动状态；活动中
 */
public class DoingState extends State {

    public Result arrangement(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动中不可提审");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动中不可审核通过");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动中不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动中不可撤销审核");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动关闭成功");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动中不可开启");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动中不可重复执行");
    }

}
