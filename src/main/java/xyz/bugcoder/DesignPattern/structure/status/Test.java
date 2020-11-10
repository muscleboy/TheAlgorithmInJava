package xyz.bugcoder.DesignPattern.structure.status;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.status
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 15:39
 */
public class Test {

    private Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public void test_Arrangement() {
        String activityId = "100001";

        ActivityService.init(activityId, Status.Editing);

        StateHandler stateHandler = new StateHandler();

        Result result = stateHandler.arrangement(activityId, Status.Editing);

        logger.info("测试结果(编辑中To提审活动)：{}", JSON.toJSONString(result));

        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
                JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @org.junit.Test
    public void test_Editing2Open() {

        String activityId = "100001";

        ActivityService.init(activityId, Status.Editing);

        StateHandler stateHandler = new StateHandler();

        Result result = stateHandler.open(activityId, Status.Editing);

        logger.info("测试结果(编辑中To开启活动)：{}", JSON.toJSONString(result));

        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
                JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @org.junit.Test
    public void test_Check2Close() {

        String activityId = "100001";

        ActivityService.init(activityId, Status.Check);

        StateHandler stateHandler = new StateHandler();

        Result result = stateHandler.close(activityId, Status.Close);

        logger.info("测试结果(Check To Close)：{}", JSON.toJSONString(result));

        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
                JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

}
