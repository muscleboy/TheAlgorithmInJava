package xyz.bugcoder.jianzhioffer.LinkedList;

/**
 * @Package: xyz.bugcoder.jianzhioffer.LinkedList
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-11 12:54
 */
public class DeleteNode_EC_203 {

    //
    public ListNode removeElements(ListNode head, int val) {
        // 头结点相等
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //
        ListNode cur = head;
        ListNode prev = dummy;

        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    // 递归
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}
