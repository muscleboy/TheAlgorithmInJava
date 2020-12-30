package xyz.bugcoder.leetcode_pp.fs.dfs;

//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
// 示例:
//
// X X X X
//X O O X
//X X O X
//X O X X
//
//
// 运行你的函数后，矩阵变为：
//
// X X X X
//X X X X
//X X X X
//X O X X
//
//
// 解释:
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 440 👎 0

import org.junit.Test;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.fs.dfs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-30 09:34
 */
public class Solve_Mid_130 {

    // 思路
    //   ① dfs把与边界相连的 'O' 变成 '#'
    //   ② 遍历 board，把 'O' -> 'X', '#' -> 'O'
    // 复杂度
    //   时间：O(N²)
    //   空间间：O(1)
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                // 是否边界
                boolean isEdge = i == 0 || i == m-1 || j == 0 || j == n-1;
                if(isEdge && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        // ②
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

//        System.out.println(Arrays.deepToString(board));
    }

    // ①
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || board[i][j] == 'X'){
            return;
        }
        board[i][j] = '#';
        // 上下左右 就是 相连的情况
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }

    @Test
    public void test(){
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
    }

}
