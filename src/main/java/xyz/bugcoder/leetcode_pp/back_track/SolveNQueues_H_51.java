package xyz.bugcoder.leetcode_pp.back_track;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例：
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
// Related Topics 回溯算法
// 👍 710 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-30 12:20
 */
public class SolveNQueues_H_51 {

    // 思路
    //   回溯，从一个位置开始，就要判断是否会 冲突(同行、同列、斜线)
    // 复杂度
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] cs : board) {
            Arrays.fill(cs, '.');
        }
        backtrack(board, res, 0);
        return res;
    }

    public void backtrack(char[][] board, List<List<String>> res, int row){
        if (row == board.length) {
            res.add(arr2List(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!isValidPos(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            backtrack(board, res, row + 1);
            board[row][i] = '.';
        }
    }

    //  判断 board[row][col] 位置是否能放置皇后
    public boolean isValidPos(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        // 判断行是否能放置皇后
        for (int i = 0; i < m; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 列
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        // 左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // char[][] 转换成 List<String>
    public List<String> arr2List(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] cs : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : cs) {
                sb.append(c);
            }
            res.add(sb.toString());
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(solveNQueens(4));
    }

}
