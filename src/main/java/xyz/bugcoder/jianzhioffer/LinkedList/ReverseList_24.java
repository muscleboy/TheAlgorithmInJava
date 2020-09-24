package xyz.bugcoder.jianzhioffer.LinkedList;
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
// Related Topics 链表
// 👍 77 👎 0

/**
 * @Package: LinkedList
 * @author: Weiyj
 * @Description: 反转 链表
 * @createTime 2020-08-07 01:40
 */
public class ReverseList_24 {

    // 解题思路：循环列表，当前节点的下一节点和当前节点的上一节点 交换
    public static Node reverseList(Node head) {
        if (head == null)
            return null;
        Node last = null;
        while (head != null) {
            Node temp = head.next;
            head.next = last;
            last = head;
            head = temp;
        }

        return last;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseList(node1).data);
    }
}
