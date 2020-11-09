package xyz.bugcoder.leetcode_pp.linkedlist;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
// Related Topics 链表
// 👍 730 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;
import xyz.bugcoder.leetcode_pp.ListNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 09:52
 */

public class SwapPairs_Mid_24 {

    // 思路：
    //   递归，每次向后走两步，两两交换
    // 复杂度：
    //   时间：O(N)，N链表为链表的长度
    //   空间：O(N)，N链表为链表的长度
    public static ListNode swapPairs(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        // 下下个
        ListNode nextNext = head.next.next;
        // 两两交换
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(nextNext);

        return newHead;
    }

    // 思路：伪头结点，迭代
    // 复杂度：
    //   时间: O(N), N为链表的长度
    //   空间: O(1)
    public static ListNode swapPairs2(ListNode head){

        // 伪头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null && temp.next.next != null){
            ListNode n1 = temp.next;
            ListNode n2 = temp.next.next;
            // 两两交换
            temp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            // temp往后走
            temp = n1;
        }

        return dummy.next;
    }

    @Test
    public void test(){
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

//        System.out.println(swapPairs(h1));
//        ListNode node = swapPairs(h1);
        System.out.println(swapPairs2(h1));
    }

}
