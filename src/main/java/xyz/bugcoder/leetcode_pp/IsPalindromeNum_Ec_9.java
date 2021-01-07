package xyz.bugcoder.leetcode_pp;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
// 👍 1357 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-07 23:55
 */
public class IsPalindromeNum_Ec_9 {

    /**
     * 是否回文数
     * @param x : x < 0 一定不是回文数
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10){
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right){
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

}
