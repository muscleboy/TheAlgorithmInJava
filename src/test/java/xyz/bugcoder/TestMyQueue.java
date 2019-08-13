package xyz.bugcoder;

import org.junit.Test;
import xyz.bugcoder.util.MyQueue;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-19 13:51
 */
public class TestMyQueue {

    @Test
    public void test(){

        MyQueue mq = new MyQueue();
        mq.add(10);
        mq.add(13);
        mq.add(14);
        mq.add(16);
        mq.add(18);

        mq.show();

        mq.poll();
        System.out.println(mq.peek());
        mq.show();

        System.out.println(mq.isEmpty());
    }

}
