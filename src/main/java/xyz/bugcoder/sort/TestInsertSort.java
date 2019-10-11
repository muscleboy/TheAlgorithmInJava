package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description:
 * @Date: 2019-10-10 22:04
 * @Author: Wyj
 */
public class TestInsertSort {

    public static void main(String[] args) {
        int[] arr = {1,4,6,54,3,7,8,5};
        System.out.println(Arrays.toString(arr));
//        insertSort(arr);
        quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // 插入排序
    public static void insertSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]){
                arr[j] = arr[j - 1];
                j --;
            }
            arr[j] = temp;
        }
    }

    // 快排
    public static void quickSort(int[] arr, int left, int right){

        if (left < right){

            int low = left;
            int high = right - 1;
            int standard = arr[left];
            while (low != high){

                if (low < high && arr[high] >= standard)
                    high --;
                arr[low] = arr[high];
                if (low < high && arr[low] <= standard)
                    low ++;
                arr[high] = arr[low];
            }
            arr[low] = standard;
            quickSort(arr, left, low);
            quickSort(arr, low + 1, right);
        }
    }

    // 希尔排序
    public static void ShellSort(int[] arr){


    }

}
