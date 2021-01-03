package xyz.bugcoder.leetcode_pp.double_pointer;

//峰值元素是指其值大于左右相邻值的元素。
//
// 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
//
// 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
//
// 你可以假设 nums[-1] = nums[n] = -∞。
//
// 示例 1:
//
// 输入: nums = [1,2,3,1]
//输出: 2
//解释: 3 是峰值元素，你的函数应该返回其索引 2。
//
// 示例 2:
//
// 输入: nums = [1,2,1,3,5,6,4]
//输出: 1 或 5
//解释: 你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
//
//
// 说明:
//
// 你的解法应该是 O(logN) 时间复杂度的。
// Related Topics 数组 二分查找
// 👍 345 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-03 11:00
 */
public class findPeakElement_M_162 {

    // 思路
    //   沿着递增一直往后找，当第一次出现递减时，此时为 峰顶元素
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            // 递减
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            }
            // 当nums[mid] <= nums[mid + 1]
            // 说明是递增的，一直往后走，就会遇到峰值
            else {
                l = mid + 1;
            }
        }
        return l;
    }

}
