package xyz.bugcoder.jianzhioffer.LinkedList;

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
// 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//
//
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5.
// Related Topics 链表 双指针
// 👍 68 👎 0

/**
 * @Package: LinkedList
 * @author: Weiyj
 * @Description: 输出该链表中倒数第k个节点
 * @createTime 2020-08-05 01:56
 */
public class GetKthNodeFromEnd_22 {

    // 双指针，pre比end多走 k 步
    public static Node getKthFromEnd(Node head, int k) {
        if (head == null || k == 0)
            return null;
        Node pre = head;
        Node end = head;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            end = end.next;
        }

        return end;
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
        System.out.println(getKthFromEnd(node1, 5));
    }

}
