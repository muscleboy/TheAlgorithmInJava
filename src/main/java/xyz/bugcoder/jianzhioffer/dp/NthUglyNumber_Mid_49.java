package xyz.bugcoder.jianzhioffer.dp;

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
// Related Topics 数学
// 👍 103 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 13:08
 */
public class NthUglyNumber_Mid_49 {

    /**
     * 思路
     *    丑数只包含因子 2, 3, 5，因此有 “丑数 == 某较小丑数 x 某因子” （例如：10 = 5 x 2）
     *    状态：dp[i] 第 i 个丑数
     *    转移方程：dp[i] = min(min(n2, n3), n5))
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a ++;
            }
            if (dp[i] == n3) {
                b ++;
            }
            if (dp[i] == n5) {
                c ++;
            }
        }
        return dp[n - 1];
    }

    @Test
    public void test(){
        System.out.println(nthUglyNumber(10));
    }

}
