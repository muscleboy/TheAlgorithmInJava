package xyz.bugcoder.leetcode_pp;

//给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
//
//        初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
//
//        选择数组 nums 开头处或者末尾处 的整数 x 。
//        你获得 multipliers[i] * x 分，并累加到你的分数中。
//        将 x 从数组 nums 中移除。
//        在执行 m 步操作后，返回 最大 分数。

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author: weiyj
 * @time 2021-02-21 11:03
 * @desc: todo
 */
public class MaximumScore_Mid_5687 {

    public int maximumScore(int[] nums, int[] multipliers) {
        int res = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int m = multipliers.length;
        for (int i : nums) {
            list.add(i);
        }
        for (int i = 0; i < m; i++) {
            if (multipliers[i] <= 0) {
                res += list.peekFirst() >= list.peekLast() ? multipliers[i] * list.pollLast() : multipliers[i] * list.pollFirst();
            }
            else {
                res += list.peekFirst() >= list.peekLast() ? multipliers[i] * list.pollFirst() : multipliers[i] * list.pollLast();
            }
        }

        return res;
    }

    @Test
    public void test(){
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};
        System.out.println(maximumScore(nums, multipliers));
    }

}
