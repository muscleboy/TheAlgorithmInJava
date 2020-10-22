package xyz.bugcoder;

import org.junit.Test;
import xyz.bugcoder.util.LoopNode;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-20 13:21
 */
public class TestLoopListNode {

    @Test
    public void test(){

        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);

        n1.insert(n2);
        n2.insert(n3);
        n3.insert(n4);

        n1.next().getData();
        n2.next().getData();
        n3.next().removeNext();
        n4.next().getData();

//        n1.show();
    }

}
