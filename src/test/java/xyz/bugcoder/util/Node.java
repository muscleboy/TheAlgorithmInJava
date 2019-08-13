package xyz.bugcoder.util;

/**
 * @Package: xyz.bugcoder.util
 * @author: Weiyj
 * @Description: 单链表
 * @createTime 2019-07-20 11:02
 */
public class Node {

    // 节点存放的数据
    int data;
    // 下一个节点
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node append(Node node){

        // 当前节点
        Node currentNode = this;
        // 循环查找下一个节点
        while (true) {

            // 下一个节点
            Node nextNode = currentNode.next;
            // 下一个节点为空，为最后一个节点了
            if (nextNode == null) {

                break;
            }
            // 当前节点为下一个节点
            currentNode = nextNode;
        }

        // 将要追加的节点 追加到 找到的节点.next
        currentNode.next = node;
        return this;
    }

    // 删除下一个节点
    public void removeNext(){

        // 获取到当前节点的下下个节点
        Node newNext = this.next.next;
        // 将下下个节点设置为下个节点
        this.next = newNext;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-20 12:50
    * @Desc: 插入节点, 当前节点之后
    * @Param:
    * @Return:
    **/
    public void insert(Node insertNode){

        // 取出下个节点，作为下下个节点
        Node nextNext = next;
        // 当前节点的next为insertNode
        next = insertNode;
        // insertNode的下一个为下下个节点
        insertNode.next = nextNext;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-24 09:19
    * @Desc: 显示所有节点信息
    * @Param:
    * @Return:
    **/
    public void show(){

        // 当前节点
        Node currentNode = this;
        while (true) {

            System.out.print(currentNode.data + " ");
            // 将当前节点的下个节点设置为 当前节点
            currentNode = currentNode.next;

            // 最后一个节点，break
            if (currentNode == null) {

                break;
            }
        }

        System.out.println();
    }

    // 获取下一个节点
    public Node next(){

        return this.next;
    }

    // 获取节点的内容
    public int getData(){

        return this.data;
    }

    // 是否为最后一个节点
    public boolean isLast(){

        return next == null;
    }
}
