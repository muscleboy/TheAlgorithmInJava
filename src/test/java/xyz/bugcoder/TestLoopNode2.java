package xyz.bugcoder;

import xyz.bugcoder.util.LoopNode2;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder
 * @Description:
 * @Date: 2019/9/3 16:46
 * @Author: Wyj
 */
public class TestLoopNode2 {

    public static void main(String[] args) {

        LoopNode2 n1 = new LoopNode2(1);
        LoopNode2 n2 = new LoopNode2(2);
        LoopNode2 n3 = new LoopNode2(3);
        LoopNode2 n4 = new LoopNode2(4);

        // 插入节点，插入到当前节点的后面
        n1.insert(n2);
        n2.insert(n3);
        n3.insert(n4);

        System.out.println(n1.next().getData());
        System.out.println(n2.next().getData());
        System.out.println(n3.next().getData());
        System.out.println(n4.next().getData());
    }

}
