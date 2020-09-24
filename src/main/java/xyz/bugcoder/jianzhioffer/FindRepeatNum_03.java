package xyz.bugcoder.jianzhioffer;

import java.util.Arrays;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.jianzhioffer
 * @Description:
     * 面试题3（一）：找出数组中重复的数字
     * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
     * 那么对应的输出是重复的数字2或者3。
 * @Date: 2019-09-28 16:46
 * @Author: Wyj
 */
public class FindRepeatNum_03 {

    public static boolean findRepeatNum(int[] arr){

        // 输出原数组的元素
        System.out.println(Arrays.toString(arr));
        // 遍历数组的每一位元素
        for (int i = 0; i < arr.length - 1; i++) {
            // 当数组arr[i](第i位置)的值 不等于 下标i的值
            while (arr[i] != i){
                // 第i位置的值 不等于 第arr[i]位置的值时，交换位置
                if (arr[i] != arr[arr[i]]){

                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }else {
                    // 相等时，说明遇到了重复的元素，输出重复的元素
                    System.out.println(arr[i]);
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 0, 6, 5, 4, 4, 5};
        findRepeatNum(arr);
    }

}
