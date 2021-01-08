package xyz.bugcoder.leetcode_pp.array;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
// 👍 800 👎 0

import org.junit.Test;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-08 11:38
 */
public class Rotate_Mid_189 {

    /**
     * nums: {1, 2, 3, 4, 5, 6, 7, 8, 9}, k: 3
     * ① {9, 8, 7, 6, 5, 4, 3, 2, 1} reverse(0, n - 1)
     * ② {5, 6, 7, 8, 9, 4, 3, 2, 1} reverse(0, k % n - 1)
     * ③ {5, 6, 7, 8, 9, 1, 2, 3, 4} reverse(k % n, n - 1)
     *
     * 复杂度：
     *   时间：O(N), 遍历 2 次数组
     *   空间：O(1)
     * @param nums
     * @param k
     */
    private void rotate(int[] nums, int k) {
        int n = nums.length;
        int remain = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, remain - 1);
        reverse(nums, remain, n - 1);
//        System.out.println(Arrays.toString(nums));
    }

    /**
     * 反转 nums[l, r]
     * @param nums : 要旋转的数组 {1, 2, 3, 4, 5, 6, 7, 8, 9}
     * @param l : 起始位置
     * @param r : 结束位置
     */
    private void reverse(int[] nums, int l, int r){
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l ++;
            r --;
        }
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 8;
        rotate(nums, k);
    }

}
