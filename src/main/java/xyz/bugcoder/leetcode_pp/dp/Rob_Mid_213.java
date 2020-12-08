package xyz.bugcoder.leetcode_pp.dp;

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-08 11:53
 */
public class Rob_Mid_213 {

    // 思路
    //   首尾不能同时偷，那就比较Math.max(偷首，偷尾)
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // 首尾不能同时偷
        return Math.max(toRob(nums, 0, nums.length - 1),
                toRob(nums, 1, nums.length));
    }

    public static int toRob(int[] nums, int start, int end){

        int first = 0;
        int second = 0;
        int max = 0;

        for (int i = start; i < end; i++) {
            max = Math.max(first, second + nums[i]);
            second = first;
            first = max;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] n = {1,2,3,1};
        System.out.println(rob(n));
    }

}
