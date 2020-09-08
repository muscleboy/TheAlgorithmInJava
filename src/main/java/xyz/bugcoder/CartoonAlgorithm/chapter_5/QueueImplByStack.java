package xyz.bugcoder.CartoonAlgorithm.chapter_5;

import java.util.Stack;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 用栈模拟一个队列，实现队列的入队、出队
 * @createTime 2020-09-08 07:40
 */
public class QueueImplByStack {

    // 入队
    private Stack<Integer> stack1 = new Stack<>();
    // 出队
    private Stack<Integer> stack2 = new Stack<>();

    // 入队  O(1)
    private void enQueue(int e){
        stack1.push(e);
    }

    // 出队，O(1), 将stack1的元素转移(pop)到stack2, 顺便就变成了倒序, 先入先出
    private Integer deQueue(){

        if (stack2.isEmpty()) {
            if (stack1.isEmpty())
                return null;
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

        }

        return stack2.pop();
    }

    @Override
    public String toString() {
        return "QueueImplByStack{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }

    public static void main(String[] args) {
        QueueImplByStack queue = new QueueImplByStack();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(5);
        System.out.println(queue);
        System.out.println(queue.deQueue());
    }

}
