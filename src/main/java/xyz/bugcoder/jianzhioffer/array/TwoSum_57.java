package xyz.bugcoder.jianzhioffer.array;

//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
//
//
// 示例 1：
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
//
//
// 示例 2：
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
//
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^6
//
// 👍 51 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 10:48
 */
public class TwoSum_57 {

    public static int[] twoSum(int[] nums, int target){

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[2];
        // 首尾双指针
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail){
            if (nums[head] + nums[tail] == target){
                result[0] = nums[head];
                result[1] = nums[tail];
                break;
            }
            // <: 说明在head的后面
            else if(nums[head] + nums[tail] < target){
                head ++;
            }
            // >: 说明在tail的前面
            else {
                tail --;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,26,30,31,47,60};
        System.out.println(Arrays.toString(twoSum(nums, 61)));
    }

}
