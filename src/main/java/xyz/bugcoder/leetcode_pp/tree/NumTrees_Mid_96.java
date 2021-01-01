package xyz.bugcoder.leetcode_pp.tree;

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例:
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// Related Topics 树 动态规划
// 👍 931 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-01 13:24
 */
public class NumTrees_Mid_96 {

    // 用[1, n] 构建一颗BST，根结点任选一个，有 n 中选发, i 属于 [1, n]
    // 构建左子树只能 从[1, i-1] 选择，有 x 种
    // 构建右子树只能 从[i+1, n] 选择，有 y 种
    // 所以以 i 为根结点构建BST，有 x * y 种
    // dp[i]: 以 i 为根结点，拥有的二叉搜索树数量
    // 复杂度
    //   时间：O(N²)
    //   空间：O(n)
    public int numTrees(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                // 总共是 i 个节点，根结点用了 1 个，dp[j]用了 j 个
                // 还剩 i - j - 1个
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(numTrees(3));
    }

}
