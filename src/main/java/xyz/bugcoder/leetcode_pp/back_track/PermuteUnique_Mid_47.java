package xyz.bugcoder.leetcode_pp.back_track;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 回溯算法
// 👍 545 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 09:58
 */
public class PermuteUnique_Mid_47 {

    List<List<Integer>> res = new ArrayList<>();

    // 思路
    //   做出选择后，标记该数使用过，回溯，标记该数未使用过，撤销选择
    // 复杂度
    //   时间：O(N * N!)
    //   空间：O(N * N!), N 为数组的长度
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        // 剪枝前提：排序
        Arrays.sort(nums);
        // 记录这个数字是否用过
        boolean[] used = new boolean[nums.length];
        backtrack(track, nums, used);
        return res;
    }

    // 路径：保存在track中
    // 选择：nums[i] 不存在于 track
    // 结束： nums中的元素全部在 track 中出现，也就是他们两长度相等
    public void backtrack(List<Integer> track, int[] nums, boolean[] used) {
        // 结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i]){
                continue;
            }
            // i > 0: 使得[i - 1]才有意义
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 做出选择
            track.add(nums[i]);
            used[i] = true;
            // 回溯
            backtrack(track, nums, used);
            // 撤销选择
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        PermuteUnique_Mid_47 p = new PermuteUnique_Mid_47();
        int[] nums = {1, 2, 1};
        System.out.println(p.permuteUnique(nums));
    }

}
