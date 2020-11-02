package xyz.bugcoder.leetcode_pp.array;

//给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
//
// 示例 1:
//
//
//输入: S = "loveleetcode", C = 'e'
//输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//
//
// 说明:
//
//
// 字符串 S 的长度范围为 [1, 10000]。
// C 是一个单字符，且保证是字符串 S 里的字符。
// S 和 C 中的所有字母均为小写字母。
//
// 👍 162 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: 字符的最短距离
 * @createTime 2020-11-02 09:43
 */
public class ShortestDistanceOfChar_Easy_821 {

    // 思路:
    //  1.只有左边有C   abc
    //  2.只有右边有C   cab
    //  3.左、右都有C   abcab
    // 复杂度分析：
    //  时间：O(N), N为S的长度
    //  空间：O(N), N为S的长度
    public static int[] shortestToChar(String S, char C) {

        int[] res = new int[S.length()];
        // 双指针
        int cur = S.indexOf(C);
        int pre = cur;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C){
                res[i] = 0;
                // 上一个C的下标
                pre = i;
                // 从i+1起，下一个C的下标
                cur = S.indexOf(C, i+1);
            }else {
                // 取 前一个、当前 位置的字符和C的距离 的最小值
                res[i] = Math.min(Math.abs(pre - i), Math.abs(cur - i));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        System.out.println(Arrays.toString(shortestToChar(S, C)));
    }

}
