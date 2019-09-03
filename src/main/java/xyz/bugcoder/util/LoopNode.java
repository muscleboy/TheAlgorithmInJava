package xyz.bugcoder.util;

/**
 * @Package: xyz.bugcoder.util
 * @author: Weiyj
 * @Description: 循环链表
 * @createTime 2019-07-20 13:07
 */
public class LoopNode {

    // 链表内容
    int data;
    // 下个节点
    LoopNode next = this;

    public LoopNode(int data) {
        this.data = data;
    }

    // 插入一个节点
    public void insert(LoopNode insertNode){

        // 取出下一个节点
        LoopNode nextNext = next;
        // 将要插入的节点 赋值 给下一个节点
        next = insertNode;
        // 要插入的节点的下一个 为 next
        insertNode.next = nextNext;
    }

    // 删除下一个节点
    public void removeNext(){

        // 当前节点的下下个节点
        LoopNode newNext = next.next;
        this.next = newNext;
    }

    // 下一个节点
    public LoopNode next(){

        return this.next;
    }

    // 获取节点的内容
    public void getData(){

        System.out.println(this.data);
    }
}
