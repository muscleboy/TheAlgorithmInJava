package xyz.bugcoder.leetcode_pp.back_track;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法
// 👍 460 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 11:03
 */
public class CombinationSum_Mid_40 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> track = new ArrayList<>();
        // 排序: 剪枝
        Arrays.sort(nums);
        backtrack(track, nums, target, 0);
        return res;
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-12-20 11:26
    * @Desc:
     * @param track : 已选择列表
     * @param nums : 给定数组
     * @param target : 目标值
     * @param begin : 开始下标
    * @Returns: void
    **/
    public void backtrack(List<Integer> track, int[] nums, int target, int begin){
        if (target < 0){
            return;
        }
        // 每次回溯的时候，target -nums[i]，那当 target == 0时，就找到一个和为 target 的列表
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            // 给定的数会有重复，排好序，可以根据下标判断
            // i > begin
            if (i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            // 已排好序，此时 target - nums[i] < 0，往后都不用找了
            // 所以直接 break
            if (target - nums[i] < 0){
                break;
            }
            track.add(nums[i]);
            // 因为元素不可以重复利用，所以从 i+1 开始
            backtrack(track, nums, target - nums[i], i + 1);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test(){
        CombinationSum_Mid_40 c = new CombinationSum_Mid_40();
        int[] nums = {10,1,2,7,6,1,5};
        int t = 8;
        System.out.println(c.combinationSum(nums, t));
    }

}
