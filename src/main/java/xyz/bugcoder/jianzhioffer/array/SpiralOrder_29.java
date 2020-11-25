package xyz.bugcoder.jianzhioffer.array;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 👍 156 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 14:45
 */
public class SpiralOrder_29 {

    // 思路
    //   定上下左右 4 个边界，每一个大循环为 1 圈，外往里
    // 复杂度
    //   时间：O(mn)
    //   空间：O(1)
    public static int[] spiralOrder(int[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        // 上下左右 四边界
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int[] res = new int[(b + 1) * (r + 1)];

        int index = 0;
        while (l <= r && t <= b){
            // 左到右
            for (int i = l; i <= r; i++) {
                res[index ++] = matrix[t][i];
            }
            t++;

            // 上到下
            for (int i = t; i <= b; i++) {
                res[index ++] = matrix[i][r];
            }
            r --;

            // 右往左
            for (int i = r; i >= l && t <= b ; i--) {
                res[index ++] = matrix[b][i];
            }
            b--;

            // 下往上
            for (int i = b; i >= t && l <= r ; i--) {
                res[index ++] = matrix[i][l];
            }
            l ++;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

}
