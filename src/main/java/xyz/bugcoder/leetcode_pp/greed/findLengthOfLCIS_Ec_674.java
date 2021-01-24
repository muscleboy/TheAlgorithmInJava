package xyz.bugcoder.leetcode_pp.greed;

//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
// Related Topics 数组
// 👍 148 👎 0

/**
 * @author: weiyj
 * @time 2021-01-24 12:13
 * @desc: todo
 */
public class findLengthOfLCIS_Ec_674 {

    /**
     * 思路
     *    贪心法，当出现 nums[i] <= nums[i-1]，就记录 i 的位置，更新最大值
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            res = Math.max(res, i - start + 1);
            // 剩余的长度 < 目前最大的 连续递增的子序列
            // 说明当前最大的就是 就是 最终的最大值，提前返回，不过好像还是 beat 50%
            if (n - start < res) {
                return res;
            }
        }
        return res;
    }

}
