package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 冒泡排序，平均时间复杂度O(n²)
 * @Date: 2019/9/7 20:11
 * @Author: Wyj
 */
public class BubbleSort {

    /**
    * @Author: Weiyj
    * @Date: 2020-08-25 07:05
    * @Desc: 基础冒泡排序
     * @param arr :
    * @Returns: void
    **/
    public static void bubbleSort(int[] arr){

        // 总共比较多少轮
        for (int i = 0; i < arr.length /2; i++) {
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

    /**
    * @Author: Weiyj
    * @Date: 2020-08-25 07:15
    * @Desc: 有序退出大循环
     * @param arr :
    * @Returns: void
    **/
    public static void bubbleSort2(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 进行交换，说明无序
                    isSorted = false;
                }
            }
            // 反之，没进行交换，说明有序
            if (isSorted) {
                break;
            }
        }
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-08-25 07:27
    * @Desc: 将最后一次交换位置设置为 内循环的边界，边界后的位置不需要循环（有序）
     * @param arr :
    * @Returns: void
    **/
    public static void bubbleSort3(int[] arr){
        // 最后一次交换位置
        int lastExchangeIndex = 0;
        // 边界
        int border = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < border; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                    // 最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            // border之后的元素，不需要在进行循环（有序）
            border = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-08-25 07:31
    * @Desc: 鸡尾酒排序基础，奇数轮左 -> 右，偶数轮右 -> 左
     * @param arr :
    * @Returns: void
    **/
    public static void bubbleSort4(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length/2; i++) {
            boolean isSorted = true;
            // 奇数轮左 -> 右
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            // 偶数轮右 -> 左
            for (int j = arr.length - i - 1; j > i; j--) {
                // 右 -> 左，所以是 j 和 j-1 比较
                if (arr[j] < arr[j - 1]){
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,53,0,43,56,657,54,2,5,9,4,4,6,89,8};
        System.out.println(Arrays.toString(arr));
        bubbleSort4(arr);
        System.out.println(Arrays.toString(arr));
    }
}