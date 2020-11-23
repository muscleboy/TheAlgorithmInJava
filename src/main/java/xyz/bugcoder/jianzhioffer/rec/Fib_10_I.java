package xyz.bugcoder.jianzhioffer.rec;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
// 输入：n = 2
//输出：1
//
//
// 示例 2：
//
// 输入：n = 5
//输出：5
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
//
// 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
// Related Topics 递归
// 👍 67 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.rec
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 10:45
 */
public class Fib_10_I {

    // 思路：
    //  斐波那契数列 F(0) = 0,   F(1) = 1
    //             F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    // 递归写法，重复计算太多，当 n 很大时，会超时
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)，递归需要的 N 的栈空间
    public static int fib(int n) {

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // dp 写法
    // 思路
    //   dp，用 a,b 保存之前的值，然后每次 sum = a + b; a = b; b = sum;  return b;
    public static   int fib2(int n) {

        if (n == 0){
            return 0;
        }

        int a = 0;
        int b = 1;
        int sum;
        for (int i = 1; i < n; i++) {
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib2(6));
    }

}
