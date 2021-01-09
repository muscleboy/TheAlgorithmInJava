package xyz.bugcoder.jianzhioffer.dp;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。
//
// 示例 1：
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//
// 示例 2:
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
// 提示：
//
//
// 2 <= n <= 58
//
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划
// 👍 141 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jianzhioffer.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-09 12:48
 */
public class CuttingRope_Mid_14 {

    /**
     * 思路：
     *    备忘录递归，以空间换时间
     * 复杂度
     *    时间：O(2^N)
     *    空间：O(N)
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        return rec(dp, n);
    }

    public int rec(int[] dp, int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        int res = 0;
        for (int i = 3; i <= n; i++) {
            // 每次比较 剪 和 不剪，取最大值
            res = Math.max(res, Math.max(i * rec(dp, n - i), i * (n - i)));
        }
        dp[n] = res;
        return dp[n];
    }

    /**
     * 思路：
     *    动态规划法
     *    dp[i]: 表示长度为 i 的时候，剪绳子能得到最大乘积
     * 复杂度
     *    时间：O(2^N)
     *    空间：O(N)
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }

        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope2(10));
    }

}
