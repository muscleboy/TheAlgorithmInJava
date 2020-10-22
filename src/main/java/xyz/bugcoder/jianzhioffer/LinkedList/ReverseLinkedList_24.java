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
public class ReverseLinkedList_24 {

    // 解题思路：循环列表，当前节点的下一节点和当前节点的上一节点 交换
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(reverseList(listNode1));
    }
}
