package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 堆排序
 * @Date: 2019-10-19 21:06
 * @Author: Wyj
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
    * @Description: 堆排序
    * @Param: [data]
    * @return: void
    */
    private static void heapSort(int[] arr) {

        // 首先建立大顶堆，从最后一个叶子节点的父节点开始
        int start = (arr.length - 1)/2;
        for (int i = start; i >= 0 ; i--) {
            buildMaxHeap(arr, arr.length, i);
//            System.out.println(Arrays.toString(arr));
        }
        // 每次把0位置和最后一个位置(i--)交换，然后建立大顶堆
        for (int i = arr.length - 1; i >= 0; i --) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 每次这么交换就得到一个升序的数组
            buildMaxHeap(arr, i, 0);
        }
    }

    /**
    * @Description: 建立最大顶堆
    * @Param: [arr, size, index] 数组，调整的长度，调整的位置
    * @return: void
    */
    private static void buildMaxHeap(int[] arr, int size, int index){

        // 左右子节点
        int leftNode = 2*index + 1;
        int rightNode = 2*index + 2;
        // 先假设一个最大值
        int max = index;
        // 分别和左右节点比较，拿到最大值
        if (leftNode < size && arr[leftNode] > arr[max]){
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]){
            max = rightNode;
        }
        // 交换位置
        if (max != index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            // 交换位置后，可能会修改原来的顺序，所以之前排好的堆要重新调整
            buildMaxHeap(arr, size, max);
        }
//        System.out.println(Arrays.toString(arr));
    }

}
