package xyz.bugcoder.jianzhioffer.array;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1:
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
//
//
//
//
// 说明：
//
//
// 用返回一个整数列表来代替打印
// n 为正整数
//
// Related Topics 数学
// 👍 59 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 11:19
 */
public class PrintNums_17 {

    public static int[] printNums(int n){

        if (n <= 0) {
            return new int[0];
        }

        // 陷阱！！！！，n很大就炸了...
        int[] res = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNums(1)));
    }

}
