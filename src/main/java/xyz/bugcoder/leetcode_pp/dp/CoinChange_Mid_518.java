package xyz.bugcoder.leetcode_pp.dp;

import java.util.Arrays;

//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
//
//
//
//
//
//
// 示例 1:
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
//
//
// 示例 2:
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
//
//
// 示例 3:
//
// 输入: amount = 10, coins = [10]
//输出: 1
//
//
//
//
// 注意:
//
// 你可以假设：
//
//
// 0 <= amount (总金额) <= 5000
// 1 <= coin (硬币面额) <= 5000
// 硬币种类不超过 500 种
// 结果符合 32 位符号整数
//
// 👍 278 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-07 11:13
 */
public class CoinChange_Mid_518 {

    // 思路
    //   总问题：凑成 11块，最少需要多少硬币数？
    //   子问题：凑成 10 块需要的最少硬币数 + 面值为 1 的硬币 之和
    //          凑成 9 块需要的最少硬币数 + 面值为 2 的硬币 之和
    //          凑成 6 块需要的最少硬币数 + 面值为 5 的硬币 之和
    //   设计成状态：
    //     1.dp[i]：凑齐面值为 i 需要的硬币数
    //     2.状态转移方程：dp[amount] = min(dp[amount], 1 + dp[amount - coins[i]])
    //          amount - coins[i] >= 0
    // 复杂度
    //    时间：O(N * amount), N 为数组的长度，amount为面值
    //    空间：O(amount)
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }

        int[] dp = new int[amount+1];
        // 凑成面值 amount，需要 amount 个 价值为 1 的硬币，
        // 这里初始化成amount + 1，是一个不可能的值，效果跟 Integer.Max_VALUE 一样
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != amount + 1){
                    // 这里+1：因为符合条件，所以这里+1 是本次满足
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        System.out.println(coinChange(c, 10));
    }

}
