package xyz.bugcoder.jianzhioffer.string;

//写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
//
//
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//
// 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连
//续的数字字符组合起来，形成整数。
//
// 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0。
//
// 说明：
//
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231
// − 1) 或 INT_MIN (−231) 。
//
// 示例 1:
//
// 输入: "42"
//输出: 42
//
//
// 示例 2:
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
//
//
// 示例 3:
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
//
//
// 示例 4:
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。
//
// 示例 5:
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
//     因此返回 INT_MIN (−231) 。
//
//
//
//
// 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/
// Related Topics 数学 字符串
// 👍 50 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jianzhioffer.string
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-15 11:46
 */
public class StrToInt_Mid_67 {

    /**
     * 思路
     *    1.去掉空格
     *    2.判断首尾(+-)
     *    3.数字部分
     *    4.超过数字部分
     * 复杂度
     *    时间：O(N)
     *    空间：O(N)
     * @param s
     * @return
     */
    public int strToInt(String s) {
        char[] cs = s.trim().toCharArray();
        if (cs.length == 0) {
            return 0;
        }
        // 因为拼接数字的时候，是每次 res *= 10 + x 的
        int res = 0, max = Integer.MAX_VALUE/10, flag = 1;
        // 默认是 '+'
        int i = 1;
        if (cs[0] == '-') {
            flag = -1;
        }
        else if (cs[0] != '+') {
            i = 0;
        }
        for (int j = i; j < cs.length; j++) {
            // 不是数字
            if (cs[j] < '0' || cs[j] > '9') {
                break;
            }
            // 超过 int 范围
            if (res > max || (res == max && cs[j] > '7')) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + cs[j] - '0';
        }
        return res;
    }

    /**
     * 思路
     *    还是一样
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param s
     * @return
     */
    public int strToInt2(String s) {
        int res = 0, max = Integer.MAX_VALUE/10, flag = 1;
        int len = s.length(), i = 0;
        // 去掉空格
        while (s.charAt(i) == ' ') {
            if (++i == len) {
                return 0;
            }
        }
        if (s.charAt(i) == '-') {
            flag = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i ++;
        }
        for (int j = i; j < len; j++) {
            char c = s.charAt(j);
            // 不是数字
            if (c < '0' || c > '9') {
                break;
            }
            // 超过 int 范围
            if (res > max || (res == max && c > '7')) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c - '0';
        }
        return flag * res;
    }

    @Test
    public void test(){
        String s = "+4193 with words";
        System.out.println(strToInt(s));
        System.out.println(strToInt2(s));
    }

}
