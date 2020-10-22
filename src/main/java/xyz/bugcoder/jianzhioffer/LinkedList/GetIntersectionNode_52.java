package xyz.bugcoder.jianzhioffer.LinkedList;

//输入两个链表，找出它们的第一个公共节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/
//
// Related Topics 链表
// 👍 118 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.LinkedList
 * @author: Weiyj
 * @Description: 两个链表的相交节点
 * @createTime 2020-10-22 09:13
 */
public class GetIntersectionNode_52 {

    // node1走了L1, C为公共部分，走到头，走node2的路，总路程为：L1 + C + L2
    // node2走了L2, C为公共部分，走到头，走node1的路，总路程为：L2 + C + L1
    // 所以它们相遇了
    public static ListNode getIntersectionNode(ListNode head1, ListNode head2){


        ListNode listNode1 = head1;
        ListNode listNode2 = head2;

        while (listNode1 != listNode2){
            listNode1 = listNode1 != null ? listNode1.next : head2;
            listNode2 = listNode2 != null ? listNode2.next : head1;
        }

        return listNode1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head2 = new ListNode(5);
        ListNode n6 = new ListNode(0);
        ListNode n7 = new ListNode(1);
        head2.next = n6;
        n6.next = n7;
        n7.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(getIntersectionNode(head1, head2));
    }

}
