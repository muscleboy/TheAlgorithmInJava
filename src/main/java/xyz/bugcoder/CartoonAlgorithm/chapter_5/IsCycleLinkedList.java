package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 判断链表是否有环
 * @createTime 2020-09-01 07:08
 */
public class IsCycleLinkedList {

    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-09-01 08:08
    * @Desc: 两个指针，一个每次移动1，另一个移动2，判断这两指针是否相同，相同则是环形的，反之...
     * 时间：O(n)
     * 空间：O(1)
     * @param head : 头结点
    * @Returns: boolean
    **/
    public static boolean isCycleLinkedList(Node head){

        Node n1 = head;
        Node n2 = head;
        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2)
                return true;
        }

        return false;
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-01 08:38
    * @Desc: 链表有环，求环的长度
     * @param head :
    * @Returns: int
    **/
    public static int getCycleLength(Node head){

        if (head == null || !isCycleLinkedList(head))
            return 0;

        Node n1 = head;
        Node n2 = head.next;
        int count = 1;
        while (n1.data != n2.data) {
            count ++;
            n1 = n1.next;
            n2 = n2.next.next;
        }

        return count;
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-02 07:47
    * @Desc: 获取入环节点，头结点到入环节点的距离 = 首次相遇点到入环点的距离
     * @param head : 头结点
     * @param meetNode : 相遇节点
    * @Returns: ListNode
    **/
    public static Node getEntryNode(Node head, Node meetNode){

        if (head == null || meetNode == null)
            return null;

        Node result = null;
        Node h = head;
        Node m = meetNode;
        if (isCycleLinkedList(head)) {
            while (h != m) {
                h = h.next;
                m = m.next;
            }
            result = h;
        }

        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(7);
        Node n4 = new Node(2);
        Node n5 = new Node(6);
        Node n6 = new Node(8);
        Node n7 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n4;
        System.out.println(isCycleLinkedList(n1));
        System.out.println(getCycleLength(n1));
        System.out.println(getEntryNode(n1, n5).data);
    }

}
