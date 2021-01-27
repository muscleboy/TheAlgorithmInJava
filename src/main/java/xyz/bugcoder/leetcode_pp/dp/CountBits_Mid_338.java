package xyz.bugcoder.leetcode_pp.dp;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,1]
//
// 示例 2:
//
// 输入: 5
//输出: [0,1,1,2,1,2]
//
// 进阶:
//
//
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
//
// Related Topics 位运算 动态规划
// 👍 488 👎 0

/**
 * @author: weiyj
 * @time 2021-01-27 10:50
 * @desc: todo
 */
public class CountBits_Mid_338 {

    /**
     * 思路
     *    dp[i]: i 的二进制数中的 1 的数目
     *    当 i 为奇数时，等于前一位dp[n-1] 中 1 的个数 + 1
     *    当 i 为偶数时，等于dp[i/2]，进位，1 后面全是 0
     * 复杂度
     *    时间：O(N)
     *    空间：O(N)
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = (i & 1) == 0 ? dp[i / 2] : dp[i - 1] + 1;
        }

        return dp;
    }

}
