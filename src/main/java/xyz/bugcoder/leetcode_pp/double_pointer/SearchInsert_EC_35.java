package xyz.bugcoder.leetcode_pp.double_pointer;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 743 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 11:48
 */
public class SearchInsert_EC_35 {

    // 思路
    //   排序的数组，2 分法
    // 复杂度
    //   时间: O(logN)
    //   空间: O(1)
    public static int searchInsert(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            int mid = (l + r)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(searchInsert(nums, 1));
    }

}
