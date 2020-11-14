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

// todo  没写完...
public class SortList_Mid_148 {

    public static ListNode sortList(ListNode head){

        if (head == null){
            return null;
        }

        ListNode cur = head;
        ListNode next = head.next;
        while (head != null){
            if (cur.val > next.val){
                cur.next = cur.next.next;
                next.next = cur;
            }
            head = head.next;
        }

        return head;
    }

    public static ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n5;

        System.out.println(getMidNode(n1));
    }

}
