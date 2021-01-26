package xyz.bugcoder.leetcode_pp.dp;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1365 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-07 10:25
 */
public class ClimbStair_EC_70 {

    // 思路
    //   总问题：有多少种不同的方法可以爬到楼顶呢？
    //   子问题：爬到第 n 层有多少种方法？ 每次 1 级 / 每次 2 级
    //   dp[n] = dp[n-1] + dp[n-2]
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static int climbStairs(int n) {
        if (n < 3){
            return n;
        }

        // 因为这里只用到了，两个临时变量，所以不用数组空间表现会更好，
        // 练习 dp
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

}
