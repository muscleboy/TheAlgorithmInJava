package xyz.bugcoder.leetcode_pp.linkedlist;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-12 10:14
 */
public class MyLinkedList2_Mid_707 {

    class ListNode{
        ListNode pre;
        ListNode next;
        int val;
        public ListNode(int val){
            this.val = val;
        }
    }

    int size;
    ListNode head;
    ListNode tail;

    public MyLinkedList2_Mid_707() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        // 比较看一下，从头比较快还是尾
        if(index + 1 < size - index){
            for(int i = 0; i < index + 1; i ++){
                cur = cur.next;
            }
        }else{
            cur = tail;
            for(int i = 0; i < size - index; i ++){
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode prev = head;
        ListNode succ = head.next;
        size ++;
        ListNode node = new ListNode(val);
        node.pre = prev;
        node.next = succ;
        prev.next = node;
        succ.pre = node;
    }

    public void addAtTail(int val) {
        ListNode succ = tail;
        ListNode prev = tail.pre;
        size ++;
        ListNode node = new ListNode(val);
        node.pre = prev;
        node.next = succ;
        prev.next = node;
        succ.pre = node;
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        ListNode prev = null, succ = null;
        if(index < size - index){
            prev = head;
            for(int i = 0; i < index; i ++){
                prev = prev.next;
                succ = prev.next;
            }
        }else{
            succ = tail;
            for(int i = 0; i < size - index; i ++){
                succ = succ.pre;
                prev = succ.pre;
            }
        }
        size ++;
        ListNode node = new ListNode(val);
        node.pre = prev;
        node.next = succ;
        prev.next = node;
        succ.pre = node;

    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        ListNode prev = null, succ = null;
        if(index < size - index){
            prev = head;
            for(int i = 0; i < index; i ++){
                prev = prev.next;
                succ = prev.next.next;
            }
        }else{
            succ = tail;
            for(int i = 0; i < size - index - 1; i ++){
                succ = succ.pre;
                prev = succ.pre.pre;
            }
        }
        size --;
        prev.next = succ;
        succ.pre = prev;
    }

}
