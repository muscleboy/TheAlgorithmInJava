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

    public ListNode getNode(int index){
        ListNode p;
        if(index <= size - index){
            p = head;
            // 获取 index 位置，所以是 =
            for(int i = 0; i <= index; i ++){
                p = p.next;
            }
        }else{
            p = tail;
            for(int i = 0; i < size - index; i ++){
                p = p.pre;
            }
        }
        return p;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode p = getNode(index);
        return p.val;
    }

    public void addAtHead(int val) {
        ListNode next = head.next;
        ListNode prev = head;
        ListNode node = new ListNode(val);

        node.pre = prev;
        node.next = next;
        prev.next = node;
        next.pre = node;

        size ++;
    }

    public void addAtTail(int val) {
        ListNode prev = tail.pre;
        ListNode next = tail;
        ListNode node = new ListNode(val);

        node.pre = prev;
        node.next = next;
        prev.next = node;
        next.pre = node;

        size ++;
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        ListNode node = new ListNode(val);
        // 原来index 位置的节点 变成了下一个节点
        ListNode next = getNode(index);
        ListNode prev = next.pre;

        node.next = next;
        node.pre = prev;
        prev.next = node;
        next.pre = node;

        size ++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        ListNode node = getNode(index);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size --;
    }

    public static void main(String[] args) {
        MyLinkedList2_Mid_707 m = new MyLinkedList2_Mid_707();
        m.addAtHead(1);
        m.addAtTail(3);
        m.addAtIndex(1, 2);
        System.out.println(m.get(1));
        m.deleteAtIndex(1);
        System.out.println(m.get(1));
    }

}
