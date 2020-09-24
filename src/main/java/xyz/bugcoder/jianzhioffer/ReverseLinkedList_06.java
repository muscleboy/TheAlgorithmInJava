package xyz.bugcoder.jianzhioffer;

import java.util.Stack;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.jianzhioffer
 * @Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Date: 2019-10-09 15:38
 * @Author: Wyj
 */

// 节点
class Node{

    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }
}

public class ReverseLinkedList_06 {

    // 常规写法
//    public static ArrayList<Integer> printListFromTail2Head(Node node){
//
//        // 临时变量
//        ArrayList<Integer> temp = new ArrayList<>();
//        ArrayList<Integer> result = new ArrayList<>();
//        // 循环遍历链表的值，放入temp中
//        while (node != null){
//
//            temp.add(node.val);
//            node = node.next;
//        }
//        // 倒序循环，放入result
//        for (int i = temp.size() - 1; i >= 0 ; i --) {
//
//            result.add(temp.get(i));
//        }
//
//        for (Integer i : result) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        return result;
//    }

    // 基于栈实现
    public static void printListFromTail2Head(Node node){

        // new一个栈
        Stack s = new Stack();
        // 遍历链表的值，添加到栈中
        while (node != null){

            s.push(node.val);
            node = node.next;
        }
        // 出栈
        while (!s.isEmpty()){

            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printListFromTail2Head(n1);
    }

}
