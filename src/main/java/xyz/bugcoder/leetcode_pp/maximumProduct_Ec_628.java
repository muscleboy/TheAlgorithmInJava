package xyz.bugcoder.leetcode_pp;

//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
// 示例 1:
//
//
//输入: [1,2,3]
//输出: 6
//
//
// 示例 2:
//
//
//输入: [1,2,3,4]
//输出: 24
//
//
// 注意:
//
//
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
//
// Related Topics 数组 数学
// 👍 254 👎 0

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: weiyj
 * @time 2021-01-20 19:59
 * @desc: todo
 */
public class maximumProduct_Ec_628 {

    /**
     * 思路
     *    max(最大3正数相乘，最小2负数*最大正数)
     * 复杂度
     *    时间：O(nlogn)
     *    空间：O(1)
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        // nlogn
        Arrays.sort(nums);
        // max(最大3正数相乘，最小2负数*最大正数)
        return Math.max(nums[0] * nums[1] * nums[n-1], nums[n-1] * nums[n-2] * nums[n-3]);
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3};
        Arrays.asList(nums);
    }

}
