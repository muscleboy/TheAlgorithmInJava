package xyz.bugcoder;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {

    // 冒泡排序
//    public static void bubbleSort(int[] arr){
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//
//                if (arr[j] > arr[j + 1]){
//
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//
//        for (Integer i : arr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }

    // 快速排序
//    public static void quickSort(int[] arr, int left, int right){
//
//        if (left < right){
//
//            int low = left;
//            int high = right;
//            int standard = arr[left];
//
//            while (low != high){
//
//                if (arr[high] >= standard && low < high)
//                    high --;
//                arr[low] = arr[high];
//                if (arr[low] <= standard && low < high)
//                    low ++;
//                arr[high] = arr[low];
//            }
//
//            arr[low] = standard;
//            quickSort(arr, left, low);
//            quickSort(arr, low + 1, right);
//        }
//    }

//    public static void selectSort(int[] arr){
//
//        for (int i = 0; i < arr.length - 1; i++) {
//
//            // 假设一个最小值，来找到真正的最小值
//            int min = i;
//            for (int j = i + 1; j < arr.length; j++) {
//
//                if (arr[j] < arr[min])
//                    // 得到最小值的下标
//                    min = j;
//            }
//
//            // 如果 i != 最小值，则交换位置，就达到排序的效果了
//            if (i != min){
//
//                int temp = arr[min];
//                arr[min] = arr[i];
//                arr[i] = temp;
//            }
//        }
    // 插入排序
    public static void insertSort(int[] arr){

        // 从下标为1的开始排序
        for (int i = 1; i < arr.length; i++) {

            // 存储当前值
            int temp = arr[i];
            int j = i;
            // 从j向前遍历，遇到比前一位还小的，就错位交换
            while (j > 0 && temp < arr[j - 1]){

                arr[j] = arr[j - 1];
                j --;
            }

            //
            arr[j] = temp;
        }

    }

    public static void main( String[] args ) {

        int[] arr = new int[]{1,43,645,86,7,4,53,2,76};
//        bubbleSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        selectSort(arr);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println( "Hello World!" );
    }
}
