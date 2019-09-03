package xyz.bugcoder;

import xyz.bugcoder.util.DoubleLinkedList;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder
 * @Description:
 * @Date: 2019/9/3 17:40
 * @Author: Wyj
 */
public class TestDoubleLinkedList {

    public static void main(String[] args) {

        DoubleLinkedList n1 = new DoubleLinkedList(1);
        DoubleLinkedList n2 = new DoubleLinkedList(2);
        DoubleLinkedList n3 = new DoubleLinkedList(3);
        DoubleLinkedList n4 = new DoubleLinkedList(4);

        n1.insert(n2);
        n2.insert(n3);
        n3.insert(n4);
        n4.insert(new DoubleLinkedList(5));

        System.out.println(n1.next().getData());
        System.out.println(n2.next().getData());
        System.out.println(n3.next().getData());
        System.out.println(n4.next().getData());
        System.out.println(n4.next().next().getData());
    }

}
