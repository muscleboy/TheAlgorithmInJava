package xyz.bugcoder.leetcode_pp.dp;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
//
//输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
//
//输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 951 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-07 11:13
 */
public class CoinChange_Mid_322 {

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
