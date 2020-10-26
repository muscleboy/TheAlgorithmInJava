package xyz.bugcoder.jianzhioffer.array;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//
//
// 示例 1：
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
//
//
// 示例 2：
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2]
//
//
//
// 限制：
//
//
// 2 <= nums.length <= 10000
//
//
//
// 👍 245 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-26 10:38
 */
public class SingleNumbers {

    // 题目要求  时间复杂度是O(n)，空间复杂度是O(1)，所以不能用排序...
    // 异或运算
    public static int[] singleNumbers(int[] nums){

        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        int xorResult = 0;
        for (int n : nums) {
            xorResult ^= n;
        }

        // =0,说明没有出现奇数次(1)的数，不符合题意
        // != 0, 说明xorResult至少有一位为 1
        if (xorResult == 0){
            return new int[]{};
        }

        //  这里是找到为 1 的那一位，下面用做分组
        int div = 1;
        while ((xorResult & div) == 0){
            div <<= 1;
        }

        int a = 0,b = 0;
        for (int n : nums) {
            if ((div & n) == 0){
                a ^= n;
            }else {
                b ^= n;
            }
        }

        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,10,4,1,4,3,3};
//        int[] nums = new int[]{4,1,4,6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

}
