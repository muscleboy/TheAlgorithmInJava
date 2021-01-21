package xyz.bugcoder.jianzhioffer.bs;

//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。
//
//
//
// 示例 1:
//
// 输入: 2.00000, 10
//输出: 1024.00000
//
//
// 示例 2:
//
// 输入: 2.10000, 3
//输出: 9.26100
//
//
// 示例 3:
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//
//
//
// 说明:
//
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
// Related Topics 递归
// 👍 109 👎 0

/**
 * @author: weiyj
 * @time 2021-01-21 11:38
 * @desc: todo
 */
public class myPow_Mid_16 {

    /**
     * 思路
     *    ① n == 0，return 1
     *    ② n < 0，变为正数，1/res
     *    ③ n > 0，
     *       n 为奇数：myPow(x * x, n/2)
     *       n 为偶数：x * myPow(x * x, n/2)
     * 复杂度
     *    时间：O(logN)
     *    空间：O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if(n < 0){
            // 当 n 为 -2147483648，递归出不来
            // return myPow(1/x, -n);

            // n < 0, 负负得正
            return 1/x * myPow(1/x, -n-1);
        }
        return ((n & 1) == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}
