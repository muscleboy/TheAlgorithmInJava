package xyz.bugcoder.leetcode_pp.linkedlist;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//
//
// 示例：
//
// 给你这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
//
//
// 说明：
//
//
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
// Related Topics 链表
// 👍 800 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.ListNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-26 11:58
 */
public class ReverseKGroups_Hard_25 {

    // 思路
    //   首先反转前 k 个，然后递归从 k+1 位置开始，往后 k 个
    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null){
            return null;
        }

        // [a, b) 不包含 b
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 剩余部分不够 K 个，就不反转
            if (b == null){
                return head;
            }
            b = b.next;
        }

        // 反转[a, b)
        ListNode newHead = reverse(a, b);
        // 此时头结点移到 b，再往后反转 k 个
        // a 为尾结点，所以要接上后面的链表
        a.next = reverseKGroup(b, k);

        return newHead;
    }

    // 反转区间 [head, end)
    public static ListNode reverse(ListNode head, ListNode end){

        ListNode newHead = null;
        ListNode cur = head;

        while (cur != end){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(reverseKGroup(n1, 3));
    }

}
