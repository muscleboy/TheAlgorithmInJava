package xyz.bugcoder.leetcode_pp;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学
// 👍 2443 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-06 22:50
 */
public class ReverseNum_Ec_7 {

    /**
     * 思路
     *   每次 % 10，获取到个位数，判断是否溢出，否则 累乘得到新的高位
     * 复杂度
     *   时间：O(logN)，10 为底数
     *   空间：O(1)
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            // 先判断，再累乘
            // 7: 2^31 - 1 个位数的 7
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            // -8: -2^31 个位数的 8
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(reverse(435323423));
    }

}
