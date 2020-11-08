package xyz.bugcoder.leetcode_pp.linkedlist;

//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针
// 👍 362 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-08 09:16
 */
public class RotationLinkedList_Mid_61 {

    // 思路
    //  1.获取到链表的长度
    //  2.收尾相连，确定断开的位置(length-k % length-1)
    //  3.确定新链表的头、尾
    // 复杂度
    //  时间：O(N)，链表的长度
    //  空间：O(1)，在原链表上操作
    public static ListNode rotationLinkedList(ListNode head, int k){

        if (head == null){
            return null;
        }

        ListNode temp = head;
        ListNode newHead;
        // 1.length
        int length = 1;
        while (temp.next != null){
            temp = temp.next;
            length ++;
        }

        // 2.收尾相连，断开点
        temp.next = head;
        // -1: 断开点的位置a
        k = (length - k % length) - 1;
        while (k > 0){
            head = head.next;
            k --;
        }
        // 3.头结点为断开点的next，断开点为尾部，next为null
        newHead = head.next;
        head.next = null;

        return newHead;
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

        System.out.println(rotationLinkedList(h1, 3));
    }

}
