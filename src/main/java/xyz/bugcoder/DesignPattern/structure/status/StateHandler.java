package xyz.bugcoder.DesignPattern.structure.status;

import xyz.bugcoder.DesignPattern.structure.status.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.status
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 15:38
 */
public class StateHandler {

    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<Enum<Status>, State>();

    public StateHandler() {

        stateMap.put(Status.Check, new CheckState()); // 待审核
        stateMap.put(Status.Close, new CloseState()); // 已关闭
        stateMap.put(Status.Doing, new DoingState()); // 活动中
        stateMap.put(Status.Editing, new EditingState()); // 编辑中
        stateMap.put(Status.Open, new OpenState()); // 已开启
        stateMap.put(Status.Pass, new PassState()); // 审核通过
        stateMap.put(Status.Refuse, new RefuseState()); // 审核拒绝

    }

    public Result arrangement(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arrangement(activityId, currentStatus);
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).close(activityId, currentStatus);
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).open(activityId, currentStatus);
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).doing(activityId, currentStatus);
    }

}
