package xyz.bugcoder.jianzhioffer;

import org.junit.Test;

//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表
// 👍 265 👎 0

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.jianzhioffer
 * @Date: 2019-09-28 16:46
 * @Author: Wyj
 */
public class FindRepeatNum_03 {

    /**
     * 思路
     *    根据题意，所有数字都在 0～n-1 的范围内，
     *    遍历数组，扫描到下标为 i 的数字时，看看找个数是不是 i
     *    不是就交换
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param arr
     * @return
     */
    public int findRepeatNum(int[] arr) {

        // 遍历数组的每一位元素
        for (int i = 0; i < arr.length - 1; i++) {
            // 当数组arr[i](第i位置)的值 不等于 下标i的值
            while (arr[i] != i) {
                // 第i位置的值 不等于 第arr[i]位置的值时，交换位置
                if (arr[i] != arr[arr[i]]) {

                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }
                else {
                    // 相等时，说明遇到了重复的元素，输出重复的元素
                    return arr[i];
                }
            }
        }

        return -1;
    }

    @Test
    public void test() {

        int[] arr = {2, 3, 1, 0, 6, 5, 4, 4, 5};
        System.out.println(findRepeatNum(arr));
    }

}
