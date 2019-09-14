package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 希尔排序
 * @Date: 2019/9/14 20:57
 * @Author: Wyj
 */
public class ShellSort {

    public static void shellSort(int[] arr){

        // 步长
        int gap = arr.length/2;
        // 步长=0时，已经不需要排序
        while (gap > 0){
            // 遍历本组所有元素
            for (int i = gap; i < arr.length; i++) {
                // j从0开始，以便和 j+gap 比较
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 第 j 位和第 j+gap 位比较，交换位置
                    if (arr[j] > arr[j + gap]){

                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            // 每次循环步长/2
            gap /= 2;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{46,55,13,42,94,17,5,70};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
