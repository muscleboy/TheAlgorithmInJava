package xyz.bugcoder.jianzhioffer.LinkedList;

//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//
// 返回删除后的链表的头节点。
//
// 注意：此题对比原题有改动
//
// 示例 1:
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//
//
// 示例 2:
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
//
//
//
//
// 说明：
//
//
// 题目保证链表中节点的值互不相同
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
//
// Related Topics 链表
// 👍 58 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.jianzhioffer.LinkedList
 * @author: Weiyj
 * @Description: 从链表删除中给定的节点
 * @createTime 2020-10-19 11:00
 */
public class DeleteNode_18 {

    public static ListNode deleteNode(ListNode head, int val){

        // 常规判空
        if (head == null){
            return null;
        }

        // 保存头结点
        ListNode result = head;
        // 如果删除的节点刚好是 头结点
        if (head.val == val){
            head = head.next;
            return head;
        }else {
            ListNode listNode = deleteNode(head.next, val);
            result.next = listNode;
            return result;
        }
    }

    public static ListNode deleteNode2(ListNode head, int val){

        // 如果删除的是 头结点
        if (head.val == val){
            return head.next;
        }

        ListNode cur = head;
        ListNode next = head.next;
        while (next != null && next.val != val){
            cur = next;
            next = next.next;
        }
        cur.next = next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        System.out.println(deleteNode(n1, 2));
        System.out.println(deleteNode2(n1, 5));
    }

}
