package xyz.bugcoder.sort;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.sort
 * @author: Weiyj
 * @Description: 计数排序
 * @createTime 2020-08-27 08:21
 */
public class CountSort {

    /**
    * @Author: Weiyj
    * @Date: 2020-08-27 08:31
    * @Desc: 计数排序
     * @param arr :
    * @Returns: void
    **/
    public static void countSort(int[] arr){
        int max = arr[0];
        // 1.找出最大值
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 2.根据
        int[] countArr = new int[max+1];
        // 3.遍历原数组，统计原数组中元素 出现的次数
        for (int i = 0; i < arr.length-1; i++) {
            countArr[arr[i]] ++;
        }
        System.out.println(Arrays.toString(countArr));
        // 4.遍历统计数组
        int index = 0;
        int[] result = new int[arr.length];
        for (int i = 0; i < countArr.length; i++) {
//            while (countArr[i] > 0){
//                result[index++] = i;
//                countArr[i] --;
//            }
            for (int j = 0; j < countArr[i]; j++) {
                result[index++] = i;
            }
        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
//        System.out.println();
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        // todo  缺少最后一位
        int[] arr = {4, 0, 6, 5, 3, 2};
        countSort(arr);
    }

}
