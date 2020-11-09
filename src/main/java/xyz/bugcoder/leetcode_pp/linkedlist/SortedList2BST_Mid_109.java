package xyz.bugcoder.leetcode_pp.linkedlist;

//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 深度优先搜索 链表
// 👍 412 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import org.junit.Test;
import xyz.bugcoder.leetcode_pp.ListNode;
import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-09 10:01
 */
public class SortedList2BST_Mid_109 {

    // 思路
    //  二叉搜索树特点：左节点 < 根结点, 右节点 > 根结点
    //  链表是升序的，快慢指针找到中间位置
    //  找到链表的中间位置(根结点)，从中间断开，中间位置为根结点，左边构建左子树，右边构建右子树
    // 时间复杂度
    //  时间：O(N)，N为链表的长度
    //  空间：Log(N)，N为链表的长度
    public static TreeNode sortedList2BST(ListNode head){

        if (head == null){
            return null;
        }

        if (head.next == null){
            return new TreeNode(head.val);
        }

        // 快慢指针，当快指针都到尾时，慢指针刚好走到中间位置(树的根结点)，需要记录中间位置的前一个位置
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = null;

        while (fast != null && fast.next != null){
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 中间位置断开, 左为左子树，右为右子树
        if (slowPre != null) {
            slowPre.next = null;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedList2BST(head);
        root.right = sortedList2BST(slow.next);

        return root;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(sortedList2BST(l1));
    }

}
