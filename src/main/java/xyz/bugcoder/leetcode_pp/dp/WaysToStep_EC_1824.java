package xyz.bugcoder.leetcode_pp.dp;

//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。
//
// 示例1:
//
//
// 输入：n = 3
// 输出：4
// 说明: 有四种走法
//
//
// 示例2:
//
//
// 输入：n = 5
// 输出：13
//
//
// 提示:
//
//
// n范围在[1, 1000000]之间
//
// Related Topics 动态规划
// 👍 32 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-07 10:10
 */
public class WaysToStep_EC_1824 {

    // 思路
    //   总问题： 跨到第n级台阶的方式有多少种？
    //   子问题： 到第 i 级台阶有多少种办法？ 跨1级/跨2级/跨3级
    //   跨 1 级: dp[i-1]
    //   跨 2 级: dp[i-2]
    //   跨 3 级: dp[i-3]
    //   总问题 dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static int waysToStep(int n) {
        if (n < 3){
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            // 当 n 很大时，结果会超过 int 值，会得到负数
            dp[i] = (dp[i-1] + (dp[i-2] + dp[i-3]) % 1000000007) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(20222));
    }

}
