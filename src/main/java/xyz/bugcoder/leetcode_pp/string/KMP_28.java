package xyz.bugcoder.leetcode_pp.string;

//实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。
//
// 示例 1:
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
//
//
// 示例 2:
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
//
//
// 说明:
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串
// 👍 650 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.string
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-22 11:26
 */
public class KMP_28 {

    // 最长前缀下标
    private int[] next;
    // 要查找的字符串
    private String pat;

    // 构建 next 数组
    public KMP_28(String pat) {
        this.pat = pat;
        this.next = new int[pat.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < pat.length(); i++) {
            // j > 0: 是为了 j-1 有意义
            // 回退到相等的位置
            while (j > 0 && pat.charAt(i) != pat.charAt(j)){
                j = next[j - 1];
            }
            if (pat.charAt(i) == pat.charAt(j)){
                j ++;
            }
            next[i] = j;
        }
    }

    // 思路
    //   使用一个数组记录当前位置的最长前缀下标
    // 复杂度
    //   时间：O(m + n)，m 为构建 next 数组，n 为匹配过程
    //   空间：O(n), n = t.length()
    public int strStr_KMP(String s, String t) {
        if(t == null || t.length() == 0){
            return 0;
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            // 一直回退到 最长前缀下标位置
            while (j > 0 && s.charAt(i) != t.charAt(j)){
                j = next[j - 1];
            }
            if (s.charAt(i) == t.charAt(j)){
                j ++;
            }
            if (j == t.length()) {
                return i - t.length() + 1;
            }
        }
        return -1;
    }

    // 思路
    //   BF 暴力法，双层 for 循环
    // 复杂度
    //   时间：O(m * n)
    //   空间：O(1)
    public int strStr_BF(String s, String t){
        if(t == null || t.length() == 0){
            return 0;
        }
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = 0; j < t.length() && s.charAt(i+j) == t.charAt(j); j++) {
                if (j == t.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "aabaabaafa";
        String t = "aabaaf";
        KMP_28 k = new KMP_28(t);
        System.out.println(k.strStr_KMP(s, t));
        System.out.println(k.strStr_BF(s, t));
    }

}
