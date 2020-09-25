package xyz.bugcoder.jianzhioffer.LinkedList;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 分治算法
// 👍 39 👎 0

/**
 * Create with IDEA.
 *
 * @Package: LinkedList
 * @Description: 合并2个有序的链表, 合并后也是有序的
 * @Date: 2020-08-12 00:14
 * @Author: Wyj
 */
public class mergeTwoSortedList_25 {

    public static Node mergeTwoLists(Node n1, Node n2) {

        // 两个空链表合并还是空
        if (n1 == null && n2 == null){
            return null;
        }

        // 其中一个为空，合并后为另一个
        if (n1 == null){
            return n2;
        }
        else if (n2 == null){
            return n1;
        }
        else if (n1.data < n2.data){
            n1.next = mergeTwoLists(n1.next, n2);
            return n1;
        }
        else {
            n2.next = mergeTwoLists(n1, n2.next);
            return n2;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n4;
        Node m1 = new Node(1);
        Node m3 = new Node(3);
        Node m4 = new Node(4);
        m1.next = m3;
        m3.next = m4;
        System.out.println(mergeTwoLists(n1, m1));
    }

}
