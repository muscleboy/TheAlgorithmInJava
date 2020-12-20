package xyz.bugcoder.leetcode_pp.back_track;

//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法
// 👍 357 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 13:08
 */
public class SubsetUnique_Mid_90 {

    List<List<Integer>> res = new ArrayList<>();

    // 思路
    //   回溯，记录开始 begin 位置，下次回溯从 begin+1 开始
    // 复杂度
    //   时间：O(N)
    //   空间：O(N) ?
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(track, nums, 0, used);
        return res;
    }

    public void backtrack(List<Integer> track, int[] nums, int begin, boolean[] used){
        // 直接 add，因为子集包括 []，第一次会为[]
        res.add(new ArrayList<>(track));
        // 终止条件为 for 循环结束
        for(int i = begin; i < nums.length; i ++){
            // 减少很多判断，beat 55.5% -> 99.5%
            if(used[i]){
                continue;
            }
            if(i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(track, nums, i + 1, used);
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetUnique_Mid_90 s = new SubsetUnique_Mid_90();
        int[] nums = {1, 2, 2};
        System.out.println(s.subsetsWithDup(nums));
    }
}
