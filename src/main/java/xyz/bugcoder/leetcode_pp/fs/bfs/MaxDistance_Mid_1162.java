package xyz.bugcoder.leetcode_pp.fs.bfs;

//你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单
//元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
//
// 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 -
//x1| + |y0 - y1| 。
//
// 如果网格上只有陆地或者海洋，请返回 -1。
//
//
//
// 示例 1：
//
//
//
// 输入：[[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释：
//海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
//
//
// 示例 2：
//
//
//
// 输入：[[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释：
//海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
//
//
//
//
// 提示：
//
//
// 1 <= grid.length == grid[0].length <= 100
// grid[i][j] 不是 0 就是 1
//
// Related Topics 广度优先搜索 图
// 👍 174 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-16 10:48
 */
public class MaxDistance_Mid_1162 {

    /**
     * 思路
     *    阅读理解不好，因为我有自己的理解！😭
     *    曼哈顿距离：就是只能横、纵坐标的走
     * 复杂度
     *    时间：O(N²)
     *    空间：O(N²)
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        // 所有的陆地入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 没有陆地 或者 全是陆地(没有海洋)
        if (queue.size() == 0 || queue.size() == m * n) {
            return -1;
        }

        // 方向，对应 DFS 中的 (i, j+1), (i, j-1)....
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int steps = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = queue.poll();
                // 上下左右 4 个方向
                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + directions[j][0];
                    int newY = cur[1] + directions[j][1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                        continue;
                    }
                    // 改为 -1，防止重复访问
                    grid[newX][newY] = -1;
                    queue.offer(new int[]{newX, newY});
                }
            }
            steps++;
        }
        // 最后为空的时候，多加了一次
        return steps - 1;
    }

}
