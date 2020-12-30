package xyz.bugcoder.leetcode_pp.back_track;

//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
//
// 给定 n 和 k，返回第 k 个排列。
//
//
//
// 示例 1：
//
//
//输入：n = 3, k = 3
//输出："213"
//
//
// 示例 2：
//
//
//输入：n = 4, k = 9
//输出："2314"
//
//
// 示例 3：
//
//
//输入：n = 3, k = 1
//输出："123"
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
// 1 <= k <= n!
//
// Related Topics 数学 回溯算法
// 👍 450 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 14:01
 */
public class GetPermutation_Hard_60 {

    // 思路
    //
    // 复杂度
    //   时间：O(N²)
    //   空间：O(N), n
    public String getPermutation(int n, int k) {

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] used = new boolean[n];

        return backtrack(nums, new ArrayList<>(), used, 0, n, k);
    }

    public String backtrack(int[] nums, List<String> track, boolean[] used, int depth, int n, int k){
        // 终止条件
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String s : track) {
                sb.append(s);
            }
            return sb.toString();
        }

        // 该位置的 排列数
        int count = calFib(n - depth - 1);
        for (int i = 0; i < n; i++) {
            // 使用过、剪枝
            if (used[i]) {
                continue;
            }
            // 如果当前的排列组合数 < k，那么就算这一层都选完了，也不满足 k 个，剪枝
            if (count < k) {
                k -= count;
                continue;
            }
            // 字符串
            track.add(nums[i] + "");
            used[i] = true;
            // 这里是直接算出来，而不是去寻找出所有的全排列，所有是直接返回
            return backtrack(nums, track, used, depth+1, n, k);
        }
        return null;
    }

    // 求 n 的阶乘
    public int calFib(int n){
        int sum = 1;
        while (n > 0) {
            sum *= n--;
        }
        return sum;
    }

    @Test
    public void test(){
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n, k));
    }

}
