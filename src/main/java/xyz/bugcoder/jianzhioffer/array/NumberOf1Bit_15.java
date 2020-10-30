package xyz.bugcoder.jianzhioffer.array;

//请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出
//2。
//
// 示例 1：
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
//
//
// 示例 2：
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
//
//
// 示例 3：
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
//
//
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
// Related Topics 位运算
// 👍 63 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-30 09:16
 */
public class NumberOf1Bit_15 {

    public static int hammingWeight(int n){

        // 逐位与1, n&1, n >>>= 1,
        int res = 0;
        while (n != 0){
            res += n & 1;
            n >>>= 1;
        }

        return res;
    }

    public static int hammingWeight2(int n){

        // x & x-1: 每次抵消一个1
        //  10:  1010
        // & 9   1001
        // = 8   1000
        int res = 0;
        while (n != 0){
            n &= n-1;
            res ++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 101235431;
        System.out.println(hammingWeight(n));
        System.out.println(hammingWeight2(n));
    }

}
