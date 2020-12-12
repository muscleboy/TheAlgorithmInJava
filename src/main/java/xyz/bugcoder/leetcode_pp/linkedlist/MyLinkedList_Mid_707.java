package xyz.bugcoder.leetcode_pp.linkedlist;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-12 10:14
 */
public class MyLinkedList_Mid_707 {

    class ListNode{
        ListNode next;
        Integer val;

        public ListNode(Integer val) {
            this.val = val;
        }
    }

    ListNode head;
    int size;

    public MyLinkedList_Mid_707() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index < 0){
            index = 0;
        }
        size ++;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        size --;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

}
