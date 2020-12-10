package xyz.bugcoder.leetcode_pp.pre_sum;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 :
//
//
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//
//
// 说明 :
//
//
// 数组的长度为 [1, 20,000]。
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
//
// Related Topics 数组 哈希表
// 👍 710 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-10 20:24
 */
public class SubArraySum_Mid_560 {

    // 思路
    //   构建前缀和，双层循环遍历 下一位置前缀 - 前一位置前缀和 == k，就+1
    // 复杂度
    //   时间：O(N²)，双层循环，效率很低
    //   空间：O(N)
    public static int subarraySum(int[] nums, int k) {

        // 构建前缀和数组
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j+1] - preSum[i] == k){
                    res ++;
                }
            }
        }

        return res;
    }

    // 思路
    //   用 map 去优化时间
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static int subarraySum2(int[] nums, int k) {
        // <preSum, count>
        Map<Integer, Integer> map = new HashMap<>();
        // 表示：前缀和为 0 的个数为 1
        map.put(0, 1);

        int count = 0;
        int preSum = 0;
        for (int n : nums) {
            preSum += n;
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4};
        System.out.println(subarraySum(nums, 4));
        System.out.println(subarraySum2(nums, 4));
    }

}
