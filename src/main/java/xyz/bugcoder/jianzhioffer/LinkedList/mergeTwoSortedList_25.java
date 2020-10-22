package xyz.bugcoder.jianzhioffer.LinkedList;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 分治算法
// 👍 39 👎 0

import java.util.List;

/**
 * Create with IDEA.
 *
 * @Package: LinkedList
 * @Description: 合并2个有序的链表, 合并后也是有序的
 * @Date: 2020-08-12 00:14
 * @Author: Wyj
 */
public class mergeTwoSortedList_25 {

    // 递归法
    public static ListNode mergeTwoLists(ListNode n1, ListNode n2) {

        // 两个空链表合并还是空
        if (n1 == null && n2 == null){
            return null;
        }

        // 其中一个为空，合并后为另一个
        if (n1 == null){
            return n2;
        }
        else if (n2 == null){
            return n1;
        }
        else if (n1.val < n2.val){
            n1.next = mergeTwoLists(n1.next, n2);
            return n1;
        }
        else {
            n2.next = mergeTwoLists(n1, n2.next);
            return n2;
        }
    }

    // 伪头结点法
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        // 伪头结点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            // < : cur的下一节点为l1, l1走向下一个
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            // >= : cur的下一节点为l2, l2走向下一个
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            // cur走向下一个
            cur = cur.next;
        }
        // l1 或 l2为空，这是追加到cur后面
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n4;
        ListNode m1 = new ListNode(1);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);
        m1.next = m3;
        m3.next = m4;
//        System.out.println(mergeTwoLists(n1, m1));
        System.out.println(mergeTwoLists2(n1, m1));
    }

}
