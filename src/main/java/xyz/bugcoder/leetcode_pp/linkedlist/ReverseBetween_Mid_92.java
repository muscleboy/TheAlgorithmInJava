package xyz.bugcoder.leetcode_pp.linkedlist;

import xyz.bugcoder.leetcode_pp.ListNode;

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 575 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-13 11:05
 */
public class ReverseBetween_Mid_92 {

    // 思路
    //   双指针，拼接[m, n]
    // 复杂度分析
    //   时间：O(N)
    //   空间：O(1)
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m == n){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode g = dummy;
        ListNode p = dummy.next;

        // g移动到第一个要反转的节点的前面
        // p移动到第一个要反转的节点的位置上
        for (int i = 0; i < m-1; i++) {
            g = g.next;
            p = p.next;
        }

        // 将 p 后面的删除，添加到 g 后面
        for (int i = 0; i < n - m; i++) {
            // 画图画图！！！
            // 链表拼接, 后往前顺序
            ListNode movedNode = p.next;
            p.next = p.next.next;

            movedNode.next = g.next;
            g.next = movedNode;
        }

        return dummy.next;
    }

    // 递归法
    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        // 当 m = 1时，就相当于反转前 n 个节点了
        if (m == 1){
            return reverseN(head, n);
        }

        head.next = reverseBetween2(head.next, m - 1, n -  1);

        return head;
    }

    // 后继节点
    static ListNode successor = null;
    // 反转前 n 个节点
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1){
            successor = head.next;
            return head;
        }

        ListNode newHead = reverseN(head.next,n - 1);
        head.next.next = head;
        head.next = successor;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        System.out.println(reverseBetween(h1, 1, 3));
//        System.out.println(reverseBetween2(h1, 1, 3));
    }

}
