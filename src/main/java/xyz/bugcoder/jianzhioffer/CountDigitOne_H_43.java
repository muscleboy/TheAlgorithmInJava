package xyz.bugcoder.jianzhioffer;

//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：5
//
//
// 示例 2：
//
//
//输入：n = 13
//输出：6
//
//
//
// 限制：
//
//
// 1 <= n < 2^31
//
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
// Related Topics 数学
// 👍 123 👎 0

import org.junit.Test;

/**
 * @author: weiyj
 * @time 2021-01-27 11:33
 * @desc: todo
 */
public class CountDigitOne_H_43 {

    /**
     * 复杂度
     *    时间：O(logN)
     *    空间：O(1)
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            // 当前位为 0 时，1 的个数只由高位 high 决定
            if (cur == 0) {
                res += high * digit;
            }
            // 当前位为 0 时，1 的个数由高位 high 和低位 low
            else if (cur == 1) {
                res += high * digit + low + 1;
            }
            // 当前位为 2~9 时，1 的个数只由高位 high 决定
            else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(countDigitOne(12));
    }

}
