package xyz.bugcoder.CartoonAlgorithm.chapter_5;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 给出一个数，找出这个正整数所有数字全排列的下一个数
 * 在一个证书所包含的数字的组合中，找到一个大于且仅大于原数的新整数
 * @createTime 2020-09-09 07:29
 */
public class FindNearestNum {

    // O(n)
    public static int[] findNearestNum(int[] nums){
        System.out.println("原数组 ：" + Arrays.toString(nums));
        // 1. 找出逆序区域的前一位index
        int index = 0;
        for (int i = nums.length - 1; i > 0 ; i--) {
            if (nums[i] > nums[i-1]){
                index = i;
                break;
            }
        }
        // 未找到，3,2,1
        if (index == 0)
            return null;

        // 2. 逆序区域的前一位 和 逆序区域>它的最小的一位 交换位置
        int head = nums[index - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (head < nums[i]){
                nums[index - 1] = nums[i];
                nums[i] = head;
                break;
            }
        }
        System.out.println("交换位置：" + Arrays.toString(nums));

        // 3. 逆序区域 -> 有序
        // index到length - 1 -> 有序
        for (int j = nums.length - 1, i = index; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        System.out.println("逆序区域 ->顺序：" + Arrays.toString(nums));

        return nums;
    }


    public static void main(String[] args) {
        // 全排列总数：5*4*3*2*1 = 120
        int[] nums = {1,2,3,5,4};
//        for (int i = 0; i < 10; i++) {
//            findNearestNum(nums);
//        }
        findNearestNum(nums);
    }

}
