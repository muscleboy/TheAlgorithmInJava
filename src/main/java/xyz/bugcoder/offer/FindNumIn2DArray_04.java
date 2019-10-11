package xyz.bugcoder.offer;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.offer
 * @Description:
 * 面试题4：二维数组中的查找
 * // 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * // 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * // 整数，判断数组中是否含有该整数。
 * @Date: 2019-09-29 16:24
 * @Author: Wyj
 */
public class FindNumIn2DArray_04 {

    // 时间复杂度O(MxN)
    public static boolean findNum(int[][] matrix, int target){

        // 总的行，列
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 从右上角(0, col-1)开始查找
        int r = 0;
        int c = cols - 1;
        while (r <= rows - 1 && c >= 0){

            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r ++;
            else
                c --;
        }
        return false;
    }

    public static void main(String[] args) {

        int arr[][] = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNum(arr, 15));
    }

}
