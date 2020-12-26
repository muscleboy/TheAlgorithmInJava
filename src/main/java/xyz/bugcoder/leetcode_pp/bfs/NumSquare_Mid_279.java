package xyz.bugcoder.leetcode_pp.bfs;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
//
// 输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//
// 示例 2:
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
// Related Topics 广度优先搜索 数学 动态规划
// 👍 716 👎 0

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bfs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-26 11:43
 */
public class NumSquare_Mid_279 {

    // 思路
    //   bfs，遍历[1, n]，寻找平方数
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> used = new HashSet<>();
        int res = 0;
        queue.offer(n);
        used.add(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            res ++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j*j <= cur; j++) {
                    int temp = cur - j*j;
                    if (temp == 0) {
                        return res;
                    }
                    if (!used.contains(temp)){
                        queue.offer(temp);
                    }
                    used.add(temp);
                }
            }
        }

        return res;
    }

    public int numSquares2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            // 最差的情况：每个数都为 1，所有 dp[i] = i * 1;
            dp[i] = i;
            // 在 i 的范围内，寻找一个平方数
            for (int j = 1; i - j*j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(numSquares(12));
        System.out.println(numSquares2(12));
    }

}
