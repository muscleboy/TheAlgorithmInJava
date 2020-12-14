package xyz.bugcoder.leetcode_pp.dp;

//爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
//
// 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
//
//
// 选出任一 x，满足 0 < x < N 且 N % x == 0 。
// 用 N - x 替换黑板上的数字 N 。
//
//
// 如果玩家无法执行这些操作，就会输掉游戏。
//
// 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
//
//
//
//
//
//
// 示例 1：
//
// 输入：2
//输出：true
//解释：爱丽丝选择 1，鲍勃无法进行操作。
//
//
// 示例 2：
//
// 输入：3
//输出：false
//解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
//
//
//
//
// 提示：
//
//
// 1 <= N <= 1000
//
// Related Topics 数学 动态规划
// 👍 263 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-14 10:45
 */
public class DivisorGame_EC_1025 {

    // 思路
    //   dp[i]: 当数位 i 时，爱丽丝是否会赢
    // 复杂度
    //   时间：O(N²)
    //   空间：O(1)
    public boolean divisorGame(int n) {
        if (n == 1){
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < n/2; j++) {
                if ((i % j == 0) && !dp[i - j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
