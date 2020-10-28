package xyz.bugcoder.jianzhioffer.array;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
//
//
// 示例：
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10000
//
// 👍 51 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-28 23:29
 */
public class OldBeforeEven {

    // 双指针
    // 时间 O(n)
    // 空间 O(1)
    public static int[] exchange(int[] nums){

        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        if(nums.length == 1){
            return nums;
        }

        int temp = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            // 是奇数
            if ((nums[i] & 1) == 1){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j ++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        System.out.println(Arrays.toString(exchange(nums)));
    }

}
