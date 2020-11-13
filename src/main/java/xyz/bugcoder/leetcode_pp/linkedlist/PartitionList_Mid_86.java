package xyz.bugcoder.leetcode_pp.linkedlist;

import xyz.bugcoder.leetcode_pp.ListNode;

//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。
//
//
//
// 示例:
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
//
// Related Topics 链表 双指针
// 👍 279 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-13 10:14
 */
public class PartitionList_Mid_86 {

    // 思路
    //   双指针，一个记录 < X的，另一个记录 >= X，最后>=的链表尾部置空, 大小链表相连
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static ListNode partition(ListNode head, int x){

        if (head == null){
            return null;
        }

        // <
        ListNode small = new ListNode(Integer.MIN_VALUE);
        ListNode s = small;
        // >=
        ListNode big = new ListNode(Integer.MAX_VALUE);
        ListNode b = big;
        while (head != null){
            if (head.val < x){
                s.next = head;
                s = s.next;
            }else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }

        // 最后一个为null
        b.next = null;
        // 连接
        s.next = big.next;

        return small.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(2);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(2);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;

        System.out.println(partition(h1, 3));
    }

}
