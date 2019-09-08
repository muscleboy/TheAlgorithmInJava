package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 选择排序
 * @Date: 2019/9/8 21:14
 * @Author: Wyj
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = new int[]{2,45,645,7567,33,234,676};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(selectSort(arr)));
    }

    public static int[] selectSort(int[] arr){

        // 比较 n-1 次
        for (int i = 0; i < arr.length - 1; i++) {

            // 假定一个最小值
            int min = i;
            // 找到比最小值还小的值，赋给min
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]){

                    min = j;
                }
            }

            // 将 i 位置和 min 位置交换
            if (i != min){

                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        return arr;
    }

}
