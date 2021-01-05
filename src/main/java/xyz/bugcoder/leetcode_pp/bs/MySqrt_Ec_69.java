package xyz.bugcoder.leetcode_pp.bs;

//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 566 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-01 13:17
 */
public class MySqrt_Ec_69 {

    // 思路
    //   从 [1, x/2] 进行二分
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long l = 1;
        long r = x/2;
        while (l < r) {
//            long mid = (l + r + 1)/2;
//            long mid = (l + r)/2  + 1;
            long mid = l + (r - l + 1)/2;
            long sqrt = mid * mid;
            if (sqrt > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int)l;
    }

    @Test
    public void test(){
        System.out.println(mySqrt(8));
    }

}
