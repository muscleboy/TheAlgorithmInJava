package xyz.bugcoder.leetcode_pp.double_pointer;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针
// 👍 631 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 10:34
 */
public class ThreeSumClosest_Mid_16 {

    // 思路
    //   先排序，固定一个，根据 sum 和 target 的大小关系，二分法
    // 复杂度
    //   时间：排序O(nlogn)，双层循环 O(n²)
    //   空间：O(1)
    public int threeSumClosest(int[] nums, int target) {

        // O(nlogn)
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                // 固定 i，因为已经排好序，二分法寻找 l, r
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - min)){
                    min = sum;
                }
                if (sum < target){
                    l ++;
                }
                // = 直接就是最接近的
                else if (sum == target){
                    return sum;
                }
                else {
                    r --;
                }
            }
        }

        return min;
    }

}
