package xyz.bugcoder.jianzhioffer.SlidingWindow;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
// Related Topics 队列 Sliding Window
// 👍 153 👎 0

import java.util.*;

/**
 * @Package: xyz.bugcoder.jianzhioffer.SlidingWindow
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 18:18
 */
public class MaxSlidingWindow_59 {

    // 思路
    //   每个窗口经过 k 次比较，能得出此窗口的最大值，长度为 n 的数组，需要比较 nk 次
    // 复杂度
    //   时间：O(nk)
    //   空间：O(1)
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        int len = nums.length;
        int[] res = new int[len - k + 1];

        for (int i = 0; i < len - k + 1; i++) {
            int max = nums[i];
            for (int j = i; j < i + k && j < len; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

}
