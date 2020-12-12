package xyz.bugcoder.leetcode_pp.linkedlist;

import xyz.bugcoder.leetcode_pp.ListNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-12 12:04
 */
public class OddEvenList_Mid_328 {

    // 思路
    //   交替的走
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static ListNode oddEvenList(ListNode head) {
        ListNode evenHead = head.next;
        // 奇
        ListNode odd = head;
        // 偶
        ListNode even = evenHead;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(oddEvenList(n1));
    }

}
