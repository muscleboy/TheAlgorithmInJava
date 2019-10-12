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
    public static void shellSort(int[] arr){

        int gap = arr.length/2;
        while (gap > 0){
            // i (gap ~ arr.length)
            for (int i = gap; i < arr.length; i++) {
                // 只循环一次
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        int temp = arr[j];
                        arr[j] = arr[gap + j];
                        arr[gap + j] = temp;
                    }
                }
            }
            gap/=2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,4,1,3,2,5,3,7,62,4,6,78,5,4,4,2,13,54};
        insertSort(arr);
        quickSort(arr, 0, arr.length);
        shellSort(arr);
    }

}
