package xyz.bugcoder.util;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.util
 * @Description: 循环链表
 * @Date: 2019/9/3 16:39
 * @Author: Wyj
 */
public class LoopNode2 {

    int data;
    // 循环链表，默认只有一个节点，也就是指向指向它自己
    LoopNode2 next = this;

    public LoopNode2(int data) {
        this.data = data;
    }

    // 插入节点，插入到当前节点的后面
    public void insert(LoopNode2 node){

        // 将当前节点的下一个节点设置为 要插入的节点的下一个
        node.next = this.next;
        // 将要插入的节点设置为 当前节点的下一个
        this.next = node;
    }

    // 获取节点数据
    public int getData(){

        return this.data;
    }

    // 获取下一个节点
    public LoopNode2 next(){

        return this.next;
    }

}
