package xyz.bugcoder.DesignPattern.structure.status;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.status
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 15:04
 */
public abstract class State {

    public abstract Result arrangement(String activityId, Enum<Status> currentStatus);

    public abstract Result checkPass(String activityId, Enum<Status> currentStatus);

    public abstract Result checkRefuse(String activityId, Enum<Status> currentStatus);

    public abstract Result checkRevoke(String activityId, Enum<Status> currentStatus);

    public abstract Result close(String activityId, Enum<Status> currentStatus);

    public abstract Result open(String activityId, Enum<Status> currentStatus);

    public abstract Result doing(String activityId, Enum<Status> currentStatus);
}
