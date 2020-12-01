package xyz.bugcoder.leetcode_pp.sliding_window;

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
// 示例1:
//
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//
//
//
//
// 示例2:
//
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//
//
//
// 注意：
//
//
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间
//
// Related Topics 双指针 Sliding Window
// 👍 202 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.sliding_window
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-30 12:29
 */
public class CheckInClusion_Mid_567 {

    // 思路
    //   滑动窗口, 首先统计 t 中各个字符出现的次数need，再用一个 map 统计滑动时的字符window
    //   当 window 中全部出现 need 中的字符，开始收缩窗口
    // 复杂度
    //   时间：O(N)
    //   空间间：O(N)
    public static boolean checkInclusion(String t, String s) {

        // 字符串 t 的各个字符
        Map<Character, Integer> need = new HashMap<>();
        // 当前窗口的各个字符
        Map<Character, Integer> window = new HashMap<>();

        // 字符串 t 的所有字母以及出现的次数
        for (char c : t.toCharArray()) {
            // 这里要用intValue()
            need.put(c, need.getOrDefault(c, 0).intValue() + 1);
        }

        // 左右
        int left = 0;
        int right = 0;
        // 表示 window 中的所有字符满足 t
        int valid = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0).intValue() + 1);
                if (need.get(c).intValue() == window.get(c).intValue()) {
                    valid++;
                }
            }

            // 当前窗口中，包含 t 中所有字符
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (need.get(d) == window.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d).intValue() - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ea";
        String s2 = "eidbeaooo";
        System.out.println(checkInclusion(s1, s2));
    }

}
