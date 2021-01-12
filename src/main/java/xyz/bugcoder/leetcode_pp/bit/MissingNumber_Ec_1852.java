package xyz.bugcoder.leetcode_pp.bit;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
// 输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
// 输入: s = "abc"
//输出: true
//
//
// 限制：
//
// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 数组
// 👍 76 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bit
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 11:31
 */
public class MissingNumber_Ec_1852 {

    /**
     * 思路
     *    用一个 int[128] 记录每一个字符出现的次数
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     *
     * @param s
     * @return
     */
    public boolean isUnique(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int[] strs = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (strs[s.charAt(i)] != 0) {
                return false;
            }
            strs[s.charAt(i)]++;
        }
        return true;
    }

    /**
     * 思路
     *    只适用于 26 个小写字母
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param s
     * @return
     */
    public boolean isUnique2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int bit = 0;
        for (int i = 0; i < s.length(); i++) {
            // 距离 0 的位置，也就是 A-1，B-2...
            int dis = s.charAt(i) - '0';
            int move = 1 << dis;
            int isRepeat = bit & move;
            // 说明此位置(此字符) 重复出现
            if (isRepeat != 0) {
                return false;
            }
            else {
                bit = bit | move;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "asdf";
        System.out.println(isUnique(s));
        System.out.println(isUnique2(s));
    }

}
