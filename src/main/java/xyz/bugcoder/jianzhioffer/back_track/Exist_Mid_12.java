package xyz.bugcoder.jianzhioffer.back_track;

//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
// [["a","b","c","e"],
//["s","f","c","s"],
//["a","d","e","e"]]
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 深度优先搜索
// 👍 222 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-09 11:48
 */
public class Exist_Mid_12 {

    /**
     * 思路
     *    dfs + 剪枝
     * 复杂度
     *    时间：O(3^k * MN)
     *    时间：O(k)，k 为 word 的长度
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // 转成数组速度更快
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] words, int index) {
        // words[index]的速度会比 String.charAt(index)
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || index > words.length || board[i][j] != words[index]) {
            return false;
        }
        // 找到了，就结束搜索
        if (index == words.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board, i, j + 1, words, index + 1)
                || dfs(board, i, j - 1, words, index + 1)
                || dfs(board, i + 1, j, words, index + 1)
                || dfs(board, i - 1, j, words, index + 1);
        board[i][j] = temp;
        // 还可以用
        // board[i][j] = words[index];
        return res;
    }

}
