package xyz.bugcoder.CartoonAlgorithm.chapter_5;

import org.junit.Test;

import java.util.Arrays;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组
// 👍 929 👎 0

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @createTime 2020-09-09 07:29
 */
public class FindNearestNum {

    // O(n)
    public int[] findNearestNum(int[] nums) {
        System.out.println("原数组 ：" + Arrays.toString(nums));
        // 1. 找出逆序区域的前一位index
        int index = 0;
        for (int i = nums.length - 1; i > 0 ; i--) {
            if (nums[i] > nums[i-1]){
                index = i;
                break;
            }
        }
        // 未找到，3,2,1
        if (index == 0)
            return null;

        // 2. 逆序区域的前一位 和 逆序区域>它的最小的一位 交换位置
        int head = nums[index - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (head < nums[i]){
                nums[index - 1] = nums[i];
                nums[i] = head;
                break;
            }
        }
        System.out.println("交换位置：" + Arrays.toString(nums));

        // 3. 逆序区域 -> 有序
        // index到length - 1 -> 有序
        for (int j = nums.length - 1, i = index; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        System.out.println("逆序区域 ->顺序：" + Arrays.toString(nums));

        return nums;
    }

    /**
     * 思路
     *    1.找到逆序区域前一个位置 index
     *    2.交换位置 swap(nums, index-1, min(nums[index:])
     *    3.reverse(nums, index, n)
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                index = i;
                break;
            }
        }

        // 没找到(已经是有序)
        if (index == -1) {
            reverse(nums, 0, n - 1);
        }
        else {
            int k = index;
            while (k + 1 < n && nums[k + 1] > nums[index - 1]) {
                k++;
            }
            swap(nums, index - 1, k);
            reverse(nums, index, n - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    @Test
    public void test() {
        // 全排列总数：5*4*3*2*1 = 120
        int[] nums = {1, 2, 3, 5, 4};
//        for (int i = 0; i < 10; i++) {
//            findNearestNum(nums);
//        }
//        findNearestNum(nums);
        nextPermutation(nums);
    }

}
