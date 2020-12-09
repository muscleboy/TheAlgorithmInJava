package xyz.bugcoder.leetcode_pp.design;

//设计实现双端队列。
//你的实现需要支持以下操作：
//
//
// MyCircularDeque(k)：构造函数,双端队列的大小为k。
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
// isEmpty()：检查双端队列是否为空。
// isFull()：检查双端队列是否满了。
//
//
// 示例：
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
// 
//
//
//
// 提示：
//
//
// 所有值的范围为 [1, 1000]
// 操作次数的范围为 [1, 1000]
// 请不要使用内置的双端队列库。
//
// Related Topics 设计 队列
// 👍 65 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.design
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-09 09:50
 */
public class MyCircularDeque_Mid_641 {

    class Node{
        Node next;
        Node pre;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    private Node tail;

    private int size;

    private int cap;

    public MyCircularDeque_Mid_641(int k) {
        this.size = 0;
        this.cap = k;
    }

    public boolean insertFront(int value) {
        // full
        if (size == cap){
            return false;
        }
        Node node = new Node(value);
        if (size == 0){
            head = tail = node;
        }else {
            head.pre = node;
            node.next = head;
            // 新的头
            head = head.pre;
        }
        size ++;
        return true;
    }

    public boolean insertLast(int value) {
        // full
        if (size == cap){
            return false;
        }
        Node node = new Node(value);
        if (size == 0){
            head = tail = node;
        }else {
            tail.next = node;
            node.pre = tail;
            // 新的尾
            tail = tail.next;
        }
        size ++;
        return true;
    }

    public boolean deleteFront() {
        // full
        if (size == 0){
            return false;
        }
        if (size == 1) {
            head = tail = null;
        }else {
            head = head.next;
            head.pre = null;
        }

        size --;
        return true;
    }

    public boolean deleteLast() {
        // full
        if (size == 0){
            return false;
        }
        if (size == 1) {
            head = tail = null;
        }else {
            tail = tail.pre;
            tail.next = null;
        }

        size --;
        return true;
    }

    public int getFront() {
        return size > 0 ? head.value : -1;
    }

    public int getRear() {
        return size > 0 ? tail.value : -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    public static void main(String[] args) {
        MyCircularDeque_Mid_641 q = new MyCircularDeque_Mid_641(3);
        System.out.println(q.insertLast(1));
        System.out.println(q.insertLast(2));
        System.out.println(q.insertFront(3));
        System.out.println(q.insertFront(4));
        System.out.println(q.getRear());
        System.out.println(q.isFull());
        System.out.println(q.deleteLast());
        System.out.println(q.insertFront(4));
        System.out.println(q.getFront());
    }

}
