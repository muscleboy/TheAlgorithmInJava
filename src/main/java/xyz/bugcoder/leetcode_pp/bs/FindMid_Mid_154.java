package xyz.bugcoder.leetcode_pp.bs;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 注意数组中可能存在重复的元素。
//
// 示例 1：
//
// 输入: [1,3,5]
//输出: 1
//
// 示例 2：
//
// 输入: [2,2,2,0,1]
//输出: 0
//
// 说明：
//
//
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
//
// Related Topics 数组 二分查找
// 👍 218 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-05 11:52
 */
public class FindMid_Mid_154 {

    // 思路
    //   根据 nums[mid] 和 nums[r] 的关系，判断旋转点的位置，遇到重复元素时，跳过
    // 复杂度
    //   时间：O(logN), 特殊情况 [2,2,2,2,2] 为 O(N)
    //   空间：O(1)
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 说明 mid 都还没到旋转点，所以 [l, mid] 不用找了
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            // 3，3，3，1，3，3，3
            // mid 往右就不用找了，但 nums[mid] 有可能是最小值
            else if (nums[mid] < nums[r]) {
                r = mid;
            }
            // 跳过重复元素
            else {
                r --;
            }
        }
        return nums[l];
    }

    @Test
    public void test(){
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(findMin(nums));
    }

}
