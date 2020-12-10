package xyz.bugcoder.leetcode_pp.pre_sum;

import java.util.HashMap;
import java.util.Map;

//给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
//
//
//
// 示例 1:
//
// 输入: [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
//
// 示例 2:
//
// 输入: [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
//
//
//
// 注意: 给定的二进制数组的长度不会超过50000。
// Related Topics 哈希表
// 👍 204 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-10 21:30
 */
public class FindMaxLen_Mid_525 {

    // 思路
    //   因为 0 和 1 出现的次数一样，将 0 改为 -1，就变成了求和为 0 的最长连续数组了
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        // 将 0 改为 -1
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            // 更新 count
            if (map.containsKey(preSum)){
                count = Math.max(count, i - map.get(preSum));
            }else {
                map.put(preSum, i);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] n = {0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(n));
    }

}
