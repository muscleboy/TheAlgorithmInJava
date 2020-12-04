package xyz.bugcoder.leetcode_pp.double_pointer;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
//
//
// 示例 3：
//
//
//输入：matrix = [], target = 0
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 0 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics 数组 二分查找
// 👍 279 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-26 09:29
 */
public class SearchMatrix_Mid_74 {

    // 思路
    //   首先从右上角开始找，根据该位置与 target 的大小关系，排除行，排除列
    // 复杂度
    //   时间: O(N)，matrix[m][n], 最多需要找 max(m, n) 次
    //   空间: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length - 1;
        int r = 0;
        int c = cols - 1;
        while(r <= rows - 1 && c >= 0){
            if(matrix[r][c] == target){
                return true;
            }
            else if (matrix[r][c] < target)
                r ++;
            else
                c --;
        }

        return false;
    }

    // 思路
    //   将二维数组展开成一维数组，一维数组中元素的坐标为 index，其在二维数组的位置为[index/n][index%n]
    //   其中 n 为 matrix[0].length
    // 复杂度
    //   时间：O(logMN)
    //   空间：O(1)
    public static boolean searchMatrix2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right){
            int mid = (left + right)/2;
            int e = matrix[mid / n][mid % n];
            if (e == target){
                return true;
            }else if(e < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int t = 11;
        System.out.println(searchMatrix(matrix, t));
        System.out.println(searchMatrix2(matrix, t));
    }

}
