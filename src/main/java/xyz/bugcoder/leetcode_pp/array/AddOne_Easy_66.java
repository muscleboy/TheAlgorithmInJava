package xyz.bugcoder.leetcode_pp.array;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组
// 👍 570 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-01 09:18
 */
public class AddOne_Easy_66 {

    /**
     * 思路
     *    从后往前，遇到 9 的位置，变为 0，前面的位置 +1
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param nums
     * @return
     */
    public static int[] addOne(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            // 进位，然后前一位 +1
            if (nums[i] == 9) {
                nums[i] = 0;
            }
            else {
                nums[i] += 1;
                return nums;
            }
        }

        // 全进位，如999
        nums = new int[nums.length + 1];
        nums[0] = 1;

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        System.out.println(Arrays.toString(addOne(nums)));
    }

}
