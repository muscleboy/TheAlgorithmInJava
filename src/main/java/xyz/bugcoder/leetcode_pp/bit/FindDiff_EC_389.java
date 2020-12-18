package xyz.bugcoder.leetcode_pp.bit;

//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
// 输入：s = "", t = "y"
//输出："y"
//
//
// 示例 3：
//
// 输入：s = "a", t = "aa"
//输出："a"
//
//
// 示例 4：
//
// 输入：s = "ae", t = "aea"
//输出："a"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
//
// Related Topics 位运算 哈希表
// 👍 192 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bit
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-18 11:45
 */
public class FindDiff_EC_389 {

    // 思路
    //   跟只出现 lc-136, lc-268 题思路一致，都是直接异或
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static char findTheDifference(String s, String t) {
        // 字符位运算(ascii 码)
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }

        return res;
    }

    @Test
    public void test(){
        String s = "a";
        String t = "aa";
        System.out.println(findTheDifference(s, t));
    }

}
