package xyz.bugcoder.leetcode_pp.linkedlist;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 815 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.ListNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-14 15:04
 */
public class SortList_Mid_148 {

    // 思路
    //   分支法，将链表分成 2 个，各自排好序，在合并成一个链表
    // 复杂度
    //   时间：O(NlogN) ?
    //   空间：O(1)
    public static ListNode sortList(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        // 获取链表中间节点，
        ListNode mid = getMidNode(head);
        ListNode right = mid.next;
        // 链表断开
        mid.next = null;

        // 排序左右两边链表
        ListNode l = sortList(head);
        ListNode r = sortList(right);

        // 合并链表
        return mergeList(l, r);
    }

    // 寻找链表的中间节点
    public static ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并链表
    public static ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(sortList(n1));
    }

}
