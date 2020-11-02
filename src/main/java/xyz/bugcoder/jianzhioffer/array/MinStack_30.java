package xyz.bugcoder.jianzhioffer.array;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// 各函数的调用总次数不超过 20000 次
//
//
//
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
// Related Topics 栈 设计
// 👍 62 👎 0

import java.util.Stack;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-02 11:01
 */
public class MinStack_30 {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack_30() {
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    @Override
    public String toString() {
        return "MinStack_30{" +
                "mainStack=" + mainStack +
                ", minStack=" + minStack +
                '}';
    }

    public static void main(String[] args) {
        MinStack_30 stack = new MinStack_30();
        stack.push(4);
        stack.push(3);
        stack.push(6);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.min());
    }

}
