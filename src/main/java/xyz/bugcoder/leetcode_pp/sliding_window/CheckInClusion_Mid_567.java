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

/**
 * @Package: xyz.bugcoder.leetcode_pp.sliding_window
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-30 12:29
 */
public class CheckInClusion_Mid_567 {

    // todo 未完，细节有问题
    public static boolean checkInclusion(String t, String s) {

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
            while (right - left >= t.length()){
                if (valid == t.length()){
                   return true;
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

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

}
