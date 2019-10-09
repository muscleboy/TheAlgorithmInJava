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

    // 普通解法，时间复杂度O(MxN)
    public static boolean findNum(int[][] arr, int target){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int arr[][] = {{1,2,8,9},
                       {2,4,9,12},
                       {4,7,10,13},
                       {6,8,11,15}};
        System.out.println(findNum(arr, 10));
    }

}
