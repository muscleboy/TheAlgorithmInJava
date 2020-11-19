package xyz.bugcoder.leetcode_pp.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针
// 👍 2757 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-19 09:48
 */
public class ThreeSum_Mid_15 {

    // 思路
    //   对数组进行排序，遍历数组, 左右双指针l= i + 1, r = len - 1，去重
    //   num[i] > 0, 再往后不可能相加为 0
    //   num[i] = num[i-1], 数组中出现重复的数
    //   sum = 0   判断去重 num[l] == num[l+1] l++;
    //   sum = 0   判断去重 num[r] == num[r-1] r--;
    //  复杂度
    //   时间：数组排序 O(N)，遍历 O(N²)
    //   空间：O(1)
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // O(nlogn)
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 因为已排好序，i 在往后都不可能相加为0
            if (nums[i] > 0){
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 左右两指针
            int l = i + 1;
            int r = len - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1]){
                        l ++;
                    }
                    while (l < r && nums[r] == nums[r - 1]){
                        r --;
                    }
                    l ++;
                    r --;
                }else if (sum < 0){
                    l ++;
                }else {
                    r --;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }

}
