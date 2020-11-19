package xyz.bugcoder.leetcode_pp.hash;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 9643 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-19 08:56
 */
public class TwoSum_EC_1 {

    // 思路
    //   循环，判断 map<值，下标> 中是否已存在 target - num[i]，有则直接返回 i 、target - nums[i]，否则放入 map
    //   这个能保证每个值只用一个
    // 复杂度
    //   时间：O(N), 需要遍历数组，对于 nums[i] 每次花 O(1)的时间寻找 target - num[i]
    //   空间：O(N), 需要个容量为数组长度的 map
    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        // 一趟循环，并且能保证每个元素只用一次
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

}
