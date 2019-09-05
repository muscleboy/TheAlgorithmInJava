package xyz.bugcoder;

import xyz.bugcoder.util.MyQueue2;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder
 * @Description:
 * @Date: 2019/9/5 21:01
 * @Author: Wyj
 */
public class TestMyQueue2 {

    public static void main(String[] args) {

        MyQueue2 q = new MyQueue2();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        q.element();
        System.out.println(q.poll());
        q.element();
        q.add(6);
        q.element();
        System.out.println(q.peek());
        q.element();
    }

}
