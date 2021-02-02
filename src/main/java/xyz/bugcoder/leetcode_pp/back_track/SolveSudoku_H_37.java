package xyz.bugcoder.leetcode_pp.back_track;

//编写一个程序，通过填充空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
// 空白格用 '.' 表示。
//
//
//
// 一个数独。
//
//
//
// 答案被标成红色。
//
// 提示：
//
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表 回溯算法
// 👍 725 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-31 21:50
 */
public class SolveSudoku_H_37 {

    // 解数独
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }
        // 此时到最后一列了，再从 下一行第一列 开始
        if (col == board.length) {
            return backtrack(board, row + 1, 0);
        }
        // 说明该位置已经有数字，从 下一列 开始
        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, row, col, c)) {
                continue;
            }
            board[row][col] = c;
            if (backtrack(board, row, col)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 行重复
            if (board[i][col] == c) {
                return false;
            }
            // 列重复
            if (board[row][i] == c) {
                return false;
            }
            // 3x3 小方格重复
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

}
