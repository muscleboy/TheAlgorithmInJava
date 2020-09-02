package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 快速排序, 平均时间复杂度O(nlogn)，最坏O(n²)
 * @Date: 2019/9/7 21:10
 * @Author: Wyj
 */
public class QuickSort {

    /**
    * @Author: Weiyj
    * @Date: 2020-08-25 08:20
    * @Desc: 快排-双边循环法
     * @param arr :
     * @param left : 起点
     * @param right : 终点
    * @Returns: void
    **/
    public static void quickSort(int[] arr, int left, int right){

        // 递归退出条件
        if (left < right){

            // 左右指针
            int low = left;
            int high = right;
            // 把第一位作为 基准值
            int pivot = arr[left];

            // 循环比较
            while (low != high){
                // 从右 --> 左，如果 >= stand，向左移一位
                while (arr[high] >= pivot && low < high)
                    high --;
                // 否则将arr[high] 替换 arr[low]
                arr[low] = arr[high];
                // 从左 --> 右，如果 <= stand，向右移一位
                while (arr[low] <= pivot && low < high)
                    low ++;
                // 否则将arr[low] 替换 arr[high]
                arr[high] = arr[low];
            }

            // 此时low = high，将stand赋给low位置
            arr[low] = pivot;
            // 递归排序左边
            quickSort(arr, left, low);
            // 递归排序右边
            quickSort(arr, low + 1, right);
        }
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-08-25 09:00
    * @Desc: 快排-单循环法
     * @param arr :
     * @param left : 起点
     * @param right : 终点
    * @Returns: void
    **/
    public static void quickSort2(int[] arr, int left, int right){

        // 递归退出条件
        if (left >= right)
            return;

        // 第一个元素为 基准元素
        int pivot = arr[left];
        // 标记
        int mark = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                mark ++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        // todo 理解
        arr[left] = arr[mark];
        arr[mark] = pivot;
        quickSort2(arr, left, mark - 1);
        quickSort2(arr, mark + 1, right);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4, 7, 3, 5, 6, 2, 8, 1};
        System.out.println(Arrays.toString(arr));
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
