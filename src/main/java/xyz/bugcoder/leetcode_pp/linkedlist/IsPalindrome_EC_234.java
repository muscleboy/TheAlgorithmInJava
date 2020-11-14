package xyz.bugcoder.leetcode_pp.linkedlist;

//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 759 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.ListNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-14 10:28
 */
public class IsPalindrome_EC_234 {

    // 思路
    //   因为反转链表的原地的，所有需要复制出一条链表，然后和反转后的比较
    // 复杂度
    //   时间：O(3N) ≈ O(N), 反转、复制、比较都要遍历依次
    //   空间：O(N)，需要额外一条链表的空间
    public static boolean isPalindrome(ListNode head) {

        ListNode h = copy(head);
        ListNode r = reverse(head);

        // 依次比较
        while (r != null && h != null){
            if (r.val == h.val){
                r = r.next;
                h = h.next;
            }
            else {
                return false;
            }
        }

        return true;
    }

    // 反转链表
    public static ListNode reverse(ListNode head){

        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }

        return newHead;
    }

    // 复制出一个一样的链表
    public static ListNode copy(ListNode head){
        if (head == null)
            return null;
        else{
            ListNode newHead = new ListNode(head.val);
            newHead.next = copy(head.next);

            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(isPalindrome(n1));
    }

}
