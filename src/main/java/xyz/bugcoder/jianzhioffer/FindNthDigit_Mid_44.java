package xyz.bugcoder.jianzhioffer;

//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。
//
// 请写一个函数，求任意第n位对应的数字。
//
//
//
// 示例 1：
//
// 输入：n = 3
//输出：3
//
//
// 示例 2：
//
// 输入：n = 11
//输出：0
//
//
//
// 限制：
//
//
// 0 <= n < 2^31
//
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
// Related Topics 数学
// 👍 81 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jianzhioffer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-11 13:01
 */
public class FindNthDigit_Mid_44 {

    // 1.确定 n 的序列化总共有多少位，bits
    // 2.确定 n 所在的数字，num
    // 3.确定 n 在 num 中的位置
    // 复杂度
    //    时间：O(logN)
    //    空间：O(1)
    public int findNthDigit(int n) {
        if(n < 10){
            return n;
        }
        int bits = 1;
        long start = 1;
        long count = 9;

        // 1.
        while(n > count){
            n -= count;
            bits += 1;
            start *= 10;
            count = bits * start * 9;
        }

        // 2.
        long num = start + (n - 1)/bits;
//        System.out.println("bits: " + bits + ", start: " + start + ", count: " + count + ", nums: " + num);

        //3.
        return Long.toString(num).charAt((n - 1) % bits) - '0';
    }

    @Test
    public void test(){
        int n = 103;
        System.out.println(findNthDigit(n));
    }

}
