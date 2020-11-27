package xyz.bugcoder.leetcode_pp.double_pointer;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 如果数组中不存在目标值，返回 [-1, -1]。
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
// Related Topics 数组 二分查找
// 👍 670 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 12:10
 */
public class FirstPosAnLastPos_Mid_34 {

    int[] res = new int[]{-1, -1};

    // 思路
    //   共享变量res数组，2 个函数，分别取找重复数的第一个下标 和 最后一个，
    //   找完第一个 如果res[0] 为-1，说明没有，直接返回不同再找第二个了
    //                    不为 -1，说明找到了，继续找最后一个
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return res;
        }
        res = findFirstPos(nums, target);
        // 未找到左边界
        if (res[0] == -1){
            return res;
        }

        return findLastPos(nums, target);
    }

    // 寻找第一个重复的位置, 左边界, [left, right]
    public int[] findFirstPos(int[] nums, int target){

        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] < target){
                l = mid + 1;
            }
            else if(nums[mid] > target){
                r = mid - 1;
            }
            else if (nums[mid] == target) {
                r = mid - 1;
            }
        }

        // 未找到
        if (l >= nums.length || nums[l] != target){
            return res;
        }

        res[0] = l;
        // 找到左边界
        return res;
    }

    // [left, right]
    public int[] findLastPos(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] < target){
                l = mid + 1;
            }
            else if(nums[mid] > target){
                r = mid - 1;
            }
            else if(nums[mid] == target){
                l = mid + 1;
            }
        }

        if (r < 0 || nums[r] != target){
            return res;
        }
        res[1] = r;
        return res;
    }

    public static void main(String[] args) {
        FirstPosAnLastPos_Mid_34 f = new FirstPosAnLastPos_Mid_34();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(f.searchRange(nums, 9)));
    }

}
