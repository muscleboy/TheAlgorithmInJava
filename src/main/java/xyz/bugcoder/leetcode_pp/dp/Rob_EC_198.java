package xyz.bugcoder.leetcode_pp.dp;

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-08 11:17
 */
public class Rob_EC_198 {

    // 思路
    //   dp[i]表示：前 i 家能抢到的最大价值
    //   当 i = 1:  max = nums[0]
    //   当 i = 2:  max = max(nums[0], nums[1]) 挑贵的抢
    //   当 i >= 2: dp[i] = max(dp[i-2] + nums[i], dp[i-1])
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)，用两个变量可以优化成 O(1)
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[dp.length - 1];
    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        // dp[0]
        int first = nums[0];
        // dp[1]
        int second = Math.max(nums[0], nums[1]);
        // dp[i]
        int temp;

        for (int i = 2; i < nums.length; i++) {
            temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        int[] n = {2,7,9,3,1};
        System.out.println(rob(n));
        System.out.println(rob2(n));
    }

}
