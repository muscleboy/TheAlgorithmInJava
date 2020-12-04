package xyz.bugcoder.leetcode_pp.stack;

import java.util.Stack;

/**
 * @Package: xyz.bugcoder.leetcode_pp.stack
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-04 14:19
 */
public class IsValid_EC_20 {

    // 思路
    //   (), {}, []成对出现，遍历到左边，就往栈里 push 右边，
    //   当遍历到右边的时候，和 pop 不相等，就是对不上，为 false
    //   最后遍历结束，如果都是成对出现，stack 应为空
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }

}
