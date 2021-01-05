package xyz.bugcoder.leetcode_pp.bs;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
//
// 请找出其中最小的元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -5000 <= nums[i] <= 5000
// nums 中的所有整数都是 唯一 的
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
//
// Related Topics 数组 二分查找
// 👍 322 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-05 11:25
 */
public class FindMin_Mid_153 {

    // 思路
    //   根据 nums[mid] 和 nums[r] 的关系，判断旋转点在 左边还是 右边，缩小搜索范围
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int l = 0;
        int r = len - 1;
        if (nums[r] > nums[l]) {
            return nums[l];
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            // [l, mid] 就不用找了
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    // 思路
    //   根据 nums[mid] 和 nums[r] 的关系，判断旋转点在 左边还是 右边，
    //   找到旋转后的递增区间，第一个为 最小值
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int findMin2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int l = 0;
        int r = len - 1;
        if (nums[r] > nums[l]) {
            return nums[l];
        }

        while (l < r) {
            // // 说明 [l, r] 递增，那就 nums[l] 最小了
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            int mid = l + (r - l) / 2;
            // [l, mid] 就不用找了
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    @Test
    public void test(){
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {3, 4, 5, 1, 2};
        int[] nums = {1};
        System.out.println(findMin(nums));
        System.out.println(findMin2(nums));
    }

}
