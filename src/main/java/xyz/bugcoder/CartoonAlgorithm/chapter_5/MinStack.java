package xyz.bugcoder.CartoonAlgorithm.chapter_5;

import java.util.Stack;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 实现一个最小栈，push, pop, getMin 时间复杂度O(1)
 * @createTime 2020-09-02 08:10
 */
public class MinStack {

    // 主栈，放所有元素
    private Stack<Integer> mainStack = new Stack<>();
    // 最小栈，只放比最小栈.peek()更小的
    private Stack<Integer> minStack = new Stack<>();

    /*
    * @Author: Weiyj
    * @Date: 2020-09-02 08:25
    * @Desc: 如果push的元素比最小栈栈顶还小或者最小栈还是空的，则放入最小栈，否则元素只放入主栈
     * @param e : 元素
    * @Returns: void
    **/
    private void push(int e){
        mainStack.push(e);
        if (minStack.isEmpty() || e <= minStack.peek())
            minStack.push(e);
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-02 08:31
    * @Desc: 主栈栈顶和最小栈栈顶相等，则最小栈pop，否则只有主栈pop
    * @Returns: Integer
    **/
    private Integer pop(){
        if (mainStack.peek().equals(minStack.peek()))
            minStack.pop();

        return mainStack.pop();
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-02 08:34
    * @Desc: 直接取最小栈栈顶(主栈不为空)
    * @Returns: Integer
    **/
    private Integer getMin() throws Exception {
        if (mainStack.isEmpty())
            throw new Exception("stack is empty");

        return minStack.pop();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "mainStack=" + mainStack +
                ", minStack=" + minStack +
                '}';
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(11);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        stack.push(10);
        stack.push(0);
        System.out.println(stack);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.getMin());
    }

}
