package xyz.bugcoder.leetcode_pp.dp;

/**
 * @Package: xyz.bugcoder.leetcode_pp.dp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-08 14:15
 */
public class NumArray_EC_303 {

    private static int[] dp;

    public NumArray_EC_303(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 这里的 dp[i]表示：从 num[0] +到 num[i]
        dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public static int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }

    public static void main(String[] args) {
        int[] n = {-2, 0, 3, -5, 2, -1};
        NumArray_EC_303 arr = new NumArray_EC_303(n);
        System.out.println(sumRange(0, 2));
    }

}
