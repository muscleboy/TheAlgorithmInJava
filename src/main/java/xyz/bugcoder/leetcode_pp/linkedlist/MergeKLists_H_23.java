package xyz.bugcoder.leetcode_pp.linkedlist;

//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1058 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.ListNode;

import java.util.PriorityQueue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-26 10:42
 */
public class MergeKLists_H_23 {

    // 思路
    //   把 lists 中所有节点都放入优先队列，再取出来就是有序的了
    // 复杂度
    //   时间：O(N)，N 为总的节点数
    //   空间：O(logK)，K 为 lists 的长度
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 默认是小的先出
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 因为链表本身就是有序的，所以可以每次放入链表的第一个节点
        for (int i = 0; i < lists.length; i++) {
            ListNode n = lists[i];
            if (n != null) {
                queue.offer(n);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        p.next = null;
        return dummy.next;
    }

    // 重复合并、效率很差，击败 10%...
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = merge2Lists(res, lists[1]);
        }

        return res;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }else {
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }

    // 分治
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return dq(lists, 0, lists.length - 1);
    }

    public ListNode dq(ListNode[] lists, int l, int r){
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l)/2;
        ListNode left = dq(lists, l, mid);
        ListNode right = dq(lists, mid+1, r);

        return merge2Lists(left, right);
    }

}
