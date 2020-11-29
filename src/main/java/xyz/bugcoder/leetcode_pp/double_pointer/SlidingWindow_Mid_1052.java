package xyz.bugcoder.leetcode_pp.double_pointer;

//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
//
//
// 示例：
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//
//
//
// 提示：
//
//
// 1 <= X <= customers.length == grumpy.length <= 20000
// 0 <= customers[i] <= 1000
// 0 <= grumpy[i] <= 1
//
// Related Topics 数组 Sliding Window
// 👍 48 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 10:22
 */
public class SlidingWindow_Mid_1052 {

    // 思路
    //   1.找到 未开挂模式时 的最大满意人数
    //   2.找到生气的最大人数
    //   最后相加
    // 复杂度
    //   时间：O(N)
    //   空间间：O(1)
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int len = customers.length;
        // 1.
        int maxNotAngry = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0){
                maxNotAngry += customers[i];
                // 计算过的 置为 0
                customers[i] = 0;
            }
        }

        int maxAngry = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            // 窗口大小为 3，求最大的生气人数
            if (i < X){
                temp += customers[i];
            }else {
                // [i - X]为窗口之前的，在 i < X 时 累加的，现在要减去
                temp += customers[i] - customers[i - X];
            }
            maxAngry = Math.max(maxAngry, temp);
        }

        return maxNotAngry + maxAngry;
    }

    public static void main(String[] args) {
        int[] c = {1,0,1,2,1,1,7,5};
        int[] g = {0,1,0,1,0,1,0,1};
        int x = 3;
        System.out.println(maxSatisfied(c, g, x));
    }

}
