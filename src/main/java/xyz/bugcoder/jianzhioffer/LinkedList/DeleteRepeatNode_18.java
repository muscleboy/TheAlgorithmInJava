package xyz.bugcoder.jianzhioffer.LinkedList;

/**
 * @Package: xyz.bugcoder.jianzhioffer.LinkedList
 * @author: Weiyj
 * @Description: 删除链表中重复的节点
 * @createTime 2020-10-23 08:59
 */

public class DeleteRepeatNode_18 {

    // 链表1->2->3->3->4->4->5 处理后为 1->2->3->4->5
    public static ListNode deleteRepeatNode(ListNode head){

        if (head == null || head.next == null){
            return null;
        }

        ListNode cur = head;
        while (cur.next != null){
            // 当前位置和下一位相等，跳过下一个位置，即cur.next = cur.next.next
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return head;
    }

    // 链表1->2->3->3->4->4->5 处理后为 1->2->5
    public static ListNode deleteRepeatNode2(ListNode head){

        if (head == null || head.next == null){
            return null;
        }

        // 伪节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;

        while (b != null && b.next != null){
            // 不等，a,b向前走
            if (a.next.val != b.next.val){
                a = a.next;
                b = b.next;
            }
            // 相等
            else {
                // 相等，b一直走到不等的位置为止
                while (b.next != null && a.next.val == b.next.val){
                    b = b.next;
                }
                // 跳过相等的部分
                a.next = b.next;
                b = b.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.println(deleteRepeatNode(listNode1));
//        System.out.println(deleteRepeatNode2(listNode1));
    }

}