package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 归并排序
 * @Date: 2019-09-17 22:24
 * @Author: Wyj
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int low, int mid, int high){

        int[] temp = new int[high - low + 1];
        int i = 0;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high){

            if (arr[i] <= arr[j]){

                temp[index] = arr[i];
                i ++;
            }else {

                temp[index] = arr[j];
                j ++;
            }
            index ++;
        }
//        while (j < high && arr[i] < arr[j]){
//
//            temp[index] = arr[i];
//            index ++;
//            j ++;
//        }

        for (int k = 0; k < temp.length - 1; k++) {

            arr[low + k] = temp[k];
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,4,5,6,2,4,7,8,9,11,12,14};
        mergeSort(arr, 0, 3, 6);
        System.out.println(Arrays.toString(arr));
    }

}
