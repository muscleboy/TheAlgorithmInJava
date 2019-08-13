package xyz.bugcoder;

import org.junit.Test;
import xyz.bugcoder.util.Node;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-20 11:04
 */
public class TestNode {

    @Test
    public void test(){

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.append(n2).append(n3);

//        System.out.println(n1.next().next().next().getData());
//        System.out.println(n1.next().isLast());
        n1.show();
        n1.next().insert(new Node(10));
        n1.show();
    }
}
