package xyz.bugcoder.jianzhioffer.array;

//统计一个数字在排序数组中出现的次数。
//
//
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/
// Related Topics 数组 二分查找
// 👍 71 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-27 09:49
 */
public class FindNumKFromSortArray_53 {

    public static int findNumK(int[] nums, int target){

        if (nums == null || nums.length == 0){
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        // 找到第一个重复的位置
        while (l <= r){
            int m = (l + r)/2;
            if (nums[m] >= target){
                r = m - 1;
            }else {
                l = m + 1;
            }
        }

        int n = 0;
        while (l < nums.length && nums[l] == target){
            l ++;
            n ++;
        }

        return n;
    }

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
// 请找出这个数字。
//
//
//
// 示例 1:
//
// 输入: [0,1,3]
//输出: 2
//
//
// 示例 2:
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 10000
// Related Topics 数组 二分查找
// 👍 72 👎 0

    // 时间：O(logN)
    // 空间：O(1)
    public static int missingNum(int[] nums){

//        遇到排序的数组记住  二分法！！！
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            int m = (i+j)/2;
            if (nums[m] == m)
                i = m + 1;
            else
                j = m - 1;
        }

        return i;
    }

    // 时间：O(N)
    // 空间：O(1)
    public static int missingNum2(int[] nums){

        if (nums[0] == 1){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    public static void main(String[] args) {
//        int[] nums = {2,2,2,2,4,5};
//        System.out.println(findNumK(nums, 4));
        int[] nums = {0,2};
        System.out.println(missingNum(nums));
        System.out.println(missingNum2(nums));
    }

}
