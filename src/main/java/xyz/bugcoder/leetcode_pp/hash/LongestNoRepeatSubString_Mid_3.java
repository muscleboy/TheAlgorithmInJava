package xyz.bugcoder.leetcode_pp.hash;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4607 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-22 09:40
 */
public class LongestNoRepeatSubString_Mid_3 {

    // 思路
    //   用 map 记录字符和下标，双指针 start 不懂，end++，遇到重复的字符，更新 start，同时记录当前的最大值
    // 复杂度
    //   时间：O(N)，只需遍历一次
    //   空间：O(N)，最大需要长度为 N 的 map，所有字符都不一样
    public static int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 双指针
        for (int start = 0, end = 0; end < len; end++) {
            char c = s.charAt(end);
            // 如果 map 中已存在，则更新 start 位置
            if (map.containsKey(c)){
                // start 是重复位置的下一位
                start = Math.max(map.get(c) + 1, start);
            }
            // // start 是重复位置的下一位
            max = Math.max(end - start + 1, max);
            map.put(c, end);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

}
