package xyz.bugcoder.leetcode_pp.back_track;

//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被
//0（代表水）包围着。
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
//
//
//
// 示例 1:
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
//
// 示例 2:
//
// [[0,0,0,0,0,0,0,0]]
//
// 对于上面这个给定的矩阵, 返回 0。
//
//
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
// Related Topics 深度优先搜索 数组
// 👍 414 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-15 10:49
 */
public class MaxAreaOfIsland_Mid_695 {

    /**
     * 思路
     *    每遇到一个为 1 的点，遍历其上下左右，记录一个最大值
     * 复杂度
     *    时间：O(M*N)
     *    时间：O(N)
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        // 越界处理
        if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1)
                + dfs(grid, i + 1, j)
                + dfs(grid, i - 1, j);
    }

}
