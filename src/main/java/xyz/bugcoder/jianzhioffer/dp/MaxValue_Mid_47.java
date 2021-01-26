package xyz.bugcoder.jianzhioffer.dp;

//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//
//
//
// 示例 1:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//
//
//
// 提示：
//
//
// 0 < grid.length <= 200
// 0 < grid[0].length <= 200
//
// Related Topics 动态规划
// 👍 91 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jianzhioffer.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-11 15:56
 */
public class MaxValue_Mid_47 {

    /**
     * 思路
     *    dp[i][j]: 当前位置的最大价值
     * 复杂度
     *    时间：O(mn)
     *    空间： O(1)
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 计算第一行
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 计算第一列
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        // 计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 思路
     *    dp[i][j]: 当前位置的最大价值
     * 复杂度
     *    时间：O(mn)
     *    空间： O(mn)
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(grid));
//        System.out.println(maxValue2(grid));
    }

}
