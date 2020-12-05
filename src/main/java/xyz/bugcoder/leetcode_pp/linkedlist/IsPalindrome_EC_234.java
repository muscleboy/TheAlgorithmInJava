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

import java.util.ArrayList;
import java.util.List;

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

    // 思路
    //   将链表的值放入List中，因为数组还需要大小，然后收尾双指针，相互比较
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)，需要长度为 N 的 List
    public static boolean isPalindrome2(ListNode head){
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p);
            p = p.next;
        }

        int l = 0;
        int r = list.size() - 1;
        while (l <= r){
            if (list.get(l).val != list.get(r).val){
                return false;
            }
            l ++;
            r --;
        }

        return true;
    }

    // 思路
    //   1.找到链表的中间位置，奇数为中间，偶数为中间靠后
    //   2.反转后半部分
    //   3.此时双指针分别从头、中间位置开始比较
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static boolean isPalindrome3(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        // 反转后半部分
        slow = reverse3(slow);
        // fast 归零(回到最初的原点)
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    // 反转链表
    public static ListNode reverse3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverse3(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
//        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n5;
//        System.out.println(isPalindrome(n1));
//        System.out.println(isPalindrome2(n1));
        System.out.println(isPalindrome3(n1));
    }

}
