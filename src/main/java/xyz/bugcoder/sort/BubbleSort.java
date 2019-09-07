package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 冒泡排序
 * @Date: 2019/9/7 20:11
 * @Author: Wyj
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1,53,0,43,56,657};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){

        // 总共比较多少轮
        for (int i = 0; i < arr.length - 1; i++) {
            // 比较次数, -i 是后面不在需要排序
            // 1,53,0,43,56,657 i = 0
            // 1,53,0,43,56,657 i = 1
            // 1,0,53,43,56,657 i = 2
            // 0,1,53,43,56,657 i = 3
            // 0,1,43,53,56,657 i = 4
            for (int j = 0; j < arr.length - 1 - i; j++) {

                // 交换位置
                if (arr[j] > arr[j + 1]){

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}