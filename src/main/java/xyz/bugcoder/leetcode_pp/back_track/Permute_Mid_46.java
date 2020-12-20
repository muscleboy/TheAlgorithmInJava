package xyz.bugcoder.leetcode_pp.back_track;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1043 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 09:58
 */
public class Permute_Mid_46 {

    List<List<Integer>> res = new ArrayList<>();

    // 思路
    //   比如 nums = {1,2,3}，第一个位置选择 1，第二选择 2，第三选择 3
    //   回溯，第一个位置选择 1，第二选择 3，第三选择 2，这样就可以得到一个排列，如此递归
    // 复杂度
    //   时间：O(N)
    //   空间：O(N), N 为数组的长度
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(track, nums);
        return res;
    }

    // 路径：保存在track中
    // 选择：nums[i] 不存在于 track
    // 结束： nums中的元素全部在 track 中出现，也就是他们两长度相等
    public void backtrack(List<Integer> track, int[] nums) {
        // 结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int n : nums) {
            if (track.contains(n)) {
                continue;
            }
            // 做出选择
            track.add(n);
            // 回溯
            backtrack(track, nums);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        Permute_Mid_46 p = new Permute_Mid_46();
        int[] nums = {1, 2, 3};
        System.out.println(p.permute(nums));
    }

}
