package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 快速排序
 * @Date: 2019/9/7 21:10
 * @Author: Wyj
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){

        // 递归退出条件
        if (left < right){

            // 左右指针
            int low = left;
            int high = right;
            // 把第一位作为 基准值
            int stand = arr[left];

            // 循环比较
            while (low != high){

                // 从右 --> 左，如果 >= stand，向左移一位
                while (arr[high] >= stand && low < high)
                    high --;
                // 否则将arr[high] 替换 arr[low]
                arr[low] = arr[high];
                // 从左 --> 右，如果 <= stand，向右移一位
                while (arr[low] <= stand && low < high)
                    low ++;
                // 否则将arr[low] 替换 arr[high]
                arr[high] = arr[low];
            }

            // 此时low = high，将stand赋给low位置
            arr[low] = stand;
            // 递归排序左边
            quickSort(arr, left, low);
            // 递归排序右边
            quickSort(arr, low + 1, right);
        }
    }

}
