package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 插入排序
 * @Date: 2019/9/13 20:48
 * @Author: Wyj
 */
public class InsertSort {

    public static void insertSort(int[] arr){

//        // 从下标为1开始，默认前1位是有序的
//        for (int i = 1; i < arr.length; i++) {
//
//            // 当前位与前一位比较
//            if (arr[i] < arr[i - 1]){
//
//                int temp = arr[i];
//                int j;
//                // 从temp之前一位开始
//                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
//                    // 将j位赋给j+1为
//                    arr[j + 1] = arr[j];
//                }
//
//                // 将最小的数temp赋给第一位
//                arr[j + 1] = temp;
//            }
//        }
        // 从下标为1开始，默认前1位是有序的
        for (int i = 1; i < arr.length; i++) {

            // 临时变量存储当前位置的值
            int temp = arr[i];
            int j = i;
            // temp比前一位小，则错位交换
            while (j > 0 && temp < arr[j - 1]){
                // 从后面已经排好序的向前遍历，前一位赋给当前为
                arr[j] = arr[j - 1];
                j --;
            }

            // 此时j为0，
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{12432,2,3,0,4,5,2,9,656,3,534,2,5,6,2,12,4,56,2,1,5,5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
