package xyz.bugcoder.interview;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description: 输出一个数的全排列
 * @Date: 2019-10-25 16:10
 * @Author: Wyj
 */
public class GetAllSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        allSort(arr,0,arr.length - 1);
    }

    public static void allSort(int[] arr, int begin, int end){

        if (begin == end){
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = begin; i <= end; i++) {
            swap(arr, begin, i);
            allSort(arr, begin + 1, end);
            swap(arr, begin, i);
        }

    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
