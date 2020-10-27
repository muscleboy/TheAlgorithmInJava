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
public class FindNumKFromSortArray {

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

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,4,5};
        System.out.println(findNumK(nums, 4));
    }

}
