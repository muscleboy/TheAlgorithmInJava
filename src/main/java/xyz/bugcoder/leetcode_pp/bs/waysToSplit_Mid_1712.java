package xyz.bugcoder.leetcode_pp.bs;

//我们称一个分割整数数组的方案是 好的 ，当它满足：
//
//
// 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
// left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
//
//
// 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1]
//输出：1
//解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,2,2,5,0]
//输出：3
//解释：nums 总共有 3 种好的分割方案：
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
//
//
// 示例 3：
//
//
//输入：nums = [3,2,1]
//输出：0
//解释：没有好的分割方案。
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 105
// 0 <= nums[i] <= 104
//
// Related Topics 双指针 二分查找
// 👍 17 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-04 10:41
 */
public class waysToSplit_Mid_1712 {

    // 思路
    //    left，mid，right，切两刀
    // 复杂度
    //    时间：O(NlogN)
    //    空间：O(N)
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        // 前缀和
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        final int MOD = 1000000000 + 7;
        long res = 0;
        // 第一刀最大到 preSum[n - 1] / 3
        // 再超过，left 部分就会超过 mid + right
        int end = preSum[n - 1] / 3;
        for (int i = 0; i < n && preSum[i] <= end; i++) {
            // 第二刀起始位置
            // preSum[i] * 2 : mid 的起始位置为 left = mid, 所以是 * 2
            int l = findLeft(i + 1, n - 1, preSum, preSum[i] * 2);
            // 第二刀结束位置
            // mid = right
            int r = findRight(i + 1, n - 1, preSum, preSum[i] + (preSum[n - 1] - preSum[i]) / 2);
            if (r >= l) {
                res += r - l + 1;
            }
        }
        return (int) (res % MOD);
    }

    public int findLeft(int l, int r, int[] preSum, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int findRight(int l, int r, int[] preSum, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }

    @Test
    public void test(){
        int[] nums = {1, 3, 9, 3, 10, 5, 7, 7};
        System.out.println(waysToSplit(nums));
    }

}
