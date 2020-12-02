package xyz.bugcoder.leetcode_pp.sliding_window;

//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。
//
//
//
// 示例：
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
//
//
// 进阶：
//
//
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
//
// Related Topics 数组 双指针 二分查找
// 👍 505 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.sliding_window
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-02 10:06
 */
public class MinSubArr_Mid_209 {

    // 思路
    //   滑动窗口，双指针 l, r，一直累加 nums[r++]，当 sum >= s，记录当前最小值，并 -=nums[l++]
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (r < len){
            sum += nums[r];
            r ++;
            while (sum >= s){
                min = Math.min(min, r - l);
                sum -= nums[l];
                l ++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

}
