package xyz.bugcoder.util;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.util
 * @Description: 双向链表
 * @Date: 2019/9/3 17:23
 * @Author: Wyj
 */
public class DoubleLinkedList {

    // 上一个
    DoubleLinkedList pre = this;
    // 下一个
    DoubleLinkedList next = this;
    int data;

    public DoubleLinkedList(int data) {
        this.data = data;
    }

    // 添加节点
    public void insert(DoubleLinkedList node){

         // 按照大话数据结构里面的顺序
        // 将当前节点 设置为 要插入的节点.pre
        node.pre = this;
        // 将当前节点.next 设置为 要插入的节点.next
        node.next = this.next;
        // 将要插入的节点 设置为 当前节点.next.pre
        this.next.pre = node;
        // 将要插入的节点 设置为 当前节点.next
        this.next = node;


//        //按照bilibili 数据结构和算法视频的顺序 4123
//        //  当前节点的下一个
//        DoubleLinkedList nextNext = next;
//        // 将要插入的节点 设置为 当前节点.next
//        this.next = node;
//        // 将当前节点 设置为 要插入节点.pre
//        node.pre = this;
//        //  将当前节点的下一个 设置为 要插入节点.next
//        node.next = nextNext;
//        //  将要插入的节点 设置为 当前节点的下一个.pre
//        nextNext.pre = node;

    }

    // 获取节点数据
    public int getData(){

        return this.data;
    }

    public DoubleLinkedList next(){

        return this.next;
    }

}
