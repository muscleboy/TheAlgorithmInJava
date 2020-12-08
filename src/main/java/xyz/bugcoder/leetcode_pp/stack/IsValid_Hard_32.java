package xyz.bugcoder.leetcode_pp.stack;

import java.util.Stack;

//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划
// 👍 1099 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.stack
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-08 10:05
 */
public class IsValid_Hard_32 {

    // 思路
    //   每遇到(，就入栈；
    //   每遇到)，就弹出栈顶，如果栈为空，就入栈；不为空，说明()成对出现，记录最大值
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

}
