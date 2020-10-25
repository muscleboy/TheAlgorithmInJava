package xyz.bugcoder.jianzhioffer.array;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
//
//
// 示例:
//
// 输入: [1,2,3,4,5]
//输出: [120,60,40,30,24]
//
//
//
// 提示：
//
//
// 所有元素乘积之和不会溢出 32 位整数
// a.length <= 100000
//
// 👍 56 👎 0

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: 构建乘积数组
 * @createTime 2020-10-25 10:41
 */
public class ConstructArr_66 {

    // 1 2 3 4 5  = 120
    // 1 1 3 4 5  = 60
    // 1 2 1 4 5  = 40
    // 1 2 3 1 5  = 30
    // 1 2 3 4 1  = 24
    public static int[] constructArr(int[] a){

        if(a == null || a.length == 0){
            return new int[]{};
        }

        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;

        // 先求出下三角
        for (int i = 1; i < a.length; i++) {
            // b[i-1] 秒啊
            b[i] = b[i - 1] * a[i - 1];
        }

        // 求出上三角，并 * 下三角
        for (int i = a.length - 2; i >= 0; i--) {
            // a[i+1]
            temp *= a[i + 1];
            b[i] *= temp;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(constructArr(a)));
    }

}
