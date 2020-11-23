package xyz.bugcoder.jianzhioffer.rec;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 示例 1：
//
// 输入：n = 2
//输出：2
//
//
// 示例 2：
//
// 输入：n = 7
//输出：21
//
//
// 示例 3：
//
// 输入：n = 0
//输出：1
//
// 提示：
//
//
// 0 <= n <= 100
//
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
//
//
// Related Topics 递归
// 👍 82 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.rec
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-22 13:27
 */
public class NumWays_EC_10_II {

    // n很大时，超时
    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return numWays(n - 2) + numWays(n - 1);
    }

    // 动态规划
    //  n级台阶: 0  1  2  3  4  5
    //  c种跳法: 1  1  2  3  5  8
    //             a  b sum
    //                a  b sum
    public static int numWays2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        int sum;
        for (int i = 2; i < n; i++) {
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(numWays(44));
        System.out.println(numWays2(44));
    }

}
