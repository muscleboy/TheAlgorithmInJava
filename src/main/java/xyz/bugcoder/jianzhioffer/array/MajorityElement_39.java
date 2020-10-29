package xyz.bugcoder.jianzhioffer.array;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
//
//
// Related Topics 位运算 分治算法
// 👍 84 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-28 22:29
 */
public class MajorityElement_39 {

    // 时间 O(n)
    // 空间 O(1)
    public static int majorityElement(int[] nums){

        if (nums == null || nums.length == 0){
            return 0;
        }

        int res = nums[0];
        int count = 0;
        for (int n : nums) {
            // 相等则count ++，反之count --，最后剩下的一定是重复次数出超过一半的, 因为其他的都被抵消了(摩尔投票法)
            if (n == res){
                count ++;
            }else if (count == 0){
                res = n;
                count = 1;
            }else {
                count --;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2, 2};
        System.out.println(majorityElement(nums));
    }

}
