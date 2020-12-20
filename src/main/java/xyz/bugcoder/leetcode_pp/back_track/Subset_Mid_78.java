package xyz.bugcoder.leetcode_pp.back_track;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法
// 👍 915 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 13:08
 */
public class Subset_Mid_78 {

    List<List<Integer>> res = new ArrayList<>();

    // 思路
    //   回溯，记录开始 begin 位置，下次回溯从 begin+1 开始
    // 复杂度
    //   时间：O(N)
    //   空间：O(N) ?
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(track, nums, 0);
        return res;
    }

    public void backtrack(List<Integer> track, int[] nums, int begin){
        // 直接 add，因为子集包括 []，第一次会为[]
        res.add(new ArrayList<>(track));
        // 终止条件为 for 循环结束
        for (int i = begin; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(track, nums, i + 1);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset_Mid_78 s = new Subset_Mid_78();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));
    }

}
