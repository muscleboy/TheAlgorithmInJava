package xyz.bugcoder;

import xyz.bugcoder.util.MyStack2;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder
 * @Description:
 * @Date: 2019/9/4 20:18
 * @Author: Wyj
 */
public class TestMyStack2 {

    public static void main(String[] args) {

        MyStack2 s = new MyStack2();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        s.peek();
        s.pop();
        s.peek();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.peek();
        System.out.println(s.isEmpty());
    }

}
