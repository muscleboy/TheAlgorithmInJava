package xyz.bugcoder.DesignPattern.structure.flyweight;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.flyweight
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 16:57
 */
public class Test {

    private Logger logger = LoggerFactory.getLogger(Test.class);
    private ActivityController activityController = new ActivityController();

    @org.junit.Test
    public void test() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            logger.info("测试结果：{} {}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }

    }

}
