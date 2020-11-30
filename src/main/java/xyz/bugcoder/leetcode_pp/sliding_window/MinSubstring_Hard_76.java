package xyz.bugcoder.leetcode_pp.sliding_window;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 843 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 11:01
 */
public class MinSubstring_Hard_76 {

    public static String minWindow(String s, String t) {

        // 字符串 t 的各个字符
        int[] need = new int[128];
        // 当前窗口的各个字符
        int[] window = new int[128];

        // 字符串 t 的所有字母以及出现的次数
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        // 左右
        int left = 0;
        int right = 0;

        // 表示 window 中的所有字符满足 t
        int valid = 0;
        int start = 0;
        // 记录一个满足 t 的最短距离
        int min = Integer.MAX_VALUE;

        while (right < s.length()) {

            char c = s.charAt(right);
            // 遇到 t 中不存在的，直接下一个
            if (need[c] == 0){
                right ++;
                continue;
            }

            // 解决 s: ab, t: a  输出：""  xxxx
            // 理应输出：a
            if (window[c] < need[c]){
                valid ++;
            }
            window[c] ++;
            right ++;

            // 当前窗口中，包含 t 中所有字符
            while (valid == t.length()){
                if (right - left < min){
                    min = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                // 对应上面 right 指向 t 中不存在的字符
                if (need[d] == 0){
                    left ++;
                    continue;
                }
                if (window[d] == need[d]){
                    valid --;
                }
                window[d] --;
                left ++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

}
