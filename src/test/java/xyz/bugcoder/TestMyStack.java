package xyz.bugcoder;

import org.junit.Test;
import xyz.bugcoder.util.MyStack;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-19 12:55
 */
public class TestMyStack {

    @Test
    public void test(){

        MyStack ms = new MyStack();
        ms.push(10);
        ms.push(13);
        ms.push(16);
        ms.push(18);
        ms.push(19);

//        ms.show();
//        System.out.println(ms.pop());
//        ms.show();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.peek();
        System.out.println(ms.isEmpty());
    }
}
