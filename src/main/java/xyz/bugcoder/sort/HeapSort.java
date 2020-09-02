package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.sort
 * @Description: 堆排序(nlogn)，能解决TopK(MinK)问题(从数组中找到最大(小)的10个数)
 * @Date: 2019-10-19 21:06
 * @Author: Wyj
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2,432,2,65,423,43,256,65,74};
//        buildMaxHeap(arr, arr.length, 0);
//        buildMinHeap(arr, arr.length, 0);
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

//        // 首先建立大顶堆，从最后一个叶子节点的父节点开始
        int start = (arr.length - 1)/2;
        for (int i = start; i >= 0 ; i--) {
            buildMaxHeap2(arr, arr.length, i);
//            System.out.println(Arrays.toString(arr));
        }
        // 每次把0位置和最后一个位置(i--)交换，然后建立大顶堆，MinK问题
        for (int i = arr.length - 1; i >= 0; i --) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 每次这么交换就得到一个升序的数组
            buildMaxHeap2(arr, i, 0);
        }
        // 首先最小顶堆，从最后一个叶子节点的父节点开始
//        int start = (arr.length - 1)/2;
//        for (int i = start; i >= 0 ; i--) {
//            buildMinHeap(arr, arr.length, i);
//        }
//        // 每次把0位置和最后一个位置(i--)交换，建立最小顶堆，TopK问题
//        for (int i = arr.length - 1; i >= 0; i--) {
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//            // 每次0位置和最后一个位置(i--)交换，就会得到一个降序
//            buildMinHeap(arr, i, 0);
//        }
    }

    /**
    * @Description: 建立最大顶堆，根结点比左右节点都大
    * @Param: [arr, size, index] 数组，调整的长度(数组的长度)，调整的位置(最大(小)位置)
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

    /**
    * @Description: 建立最小堆，根结点比左右节点都小
    * @Param: [arr, size, index]
    * @return: void
    */
    public static void buildMinHeap(int[] arr, int size, int index){

        // 左右儿子
        int leftNode = 2*index + 1;
        int rightNode = 2*index + 2;
        // 先假设一个最小值
        int min = index;

        // 判断左右儿子，找到新的最小值
        if (leftNode < size && arr[leftNode] < arr[min])
            min = leftNode;
        if (rightNode < size && arr[rightNode] < arr[min])
            min = rightNode;
        // 交换位置
        if (min != index){
            int temp = arr[index];
            arr[index] = arr[min];
            arr[min] = temp;
            // 交换位置完可能会影响之前的排序，所有递归重新建立最小顶堆
            buildMinHeap(arr, size, min);
        }

//        System.out.println(Arrays.toString(arr));
    }

    public static void buildMaxHeap2(int[] arr, int size, int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int max = index;
        if (left < size && arr[left] > arr[max])
            max = left;
        if (right < size && arr[right] > arr[max])
            max = right;
        if (max != index) {
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            buildMaxHeap2(arr, size, max);
        }
    }

}
