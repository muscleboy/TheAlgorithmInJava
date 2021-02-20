package xyz.bugcoder.leetcode_pp.dp;

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-03 13:19
 */
public class MaxProfit_EC_121 {

    // 思路
    //   遍历，找出最小值，并且计算以当前股票价格卖出去的利润，找到最大值
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int n : prices) {
            if (n < min) {
                min = n;
            }
            else if (n - min > max) {
                max = n - min;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(maxProfit(nums));
    }

}
