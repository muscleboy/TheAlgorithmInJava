package xyz.bugcoder.leetcode_pp.back_track;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1：
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2：
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯算法
// 👍 1094 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 11:03
 */
public class CombinationSum_Mid_39 {

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
            // 已排好序，此时 target - nums[i] < 0，往后都不用找了
            // 所以直接 break
            if (target - nums[i] < 0){
                break;
            }
            track.add(nums[i]);
            // 因为元素可以重复利用，所以下次还可以从 i 开始
            backtrack(track, nums, target - nums[i], i);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test(){
        CombinationSum_Mid_39 c = new CombinationSum_Mid_39();
        int[] nums = {1,2};
        int t = 4;
        System.out.println(c.combinationSum(nums, t));
    }

}
