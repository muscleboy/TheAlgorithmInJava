package xyz.bugcoder.leetcode_pp.bit;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,3,2]
//输出: 3
//
//
// 示例 2:
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99
// Related Topics 位运算
// 👍 487 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bit
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 12:38
 */
public class SingleNumber_Mid_137 {

    /**
     * 思路
     *    记录每一位为 1 的次数 count，如果 count 是 3 的倍数，
     *    那说明这个数一定是出现 3 次的数，不用管
     *    如果不是 3 的倍数，那说明 该位一定是出现一次的数的某一位
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 记录该位为 1 的次数
            int count = 0;
            for (int num : nums) {
                // 当前位为 1 的次数
                if ((num >>> i & 1) == 1) {
                    count++;
                }
            }
            // 当前位为 1 的次数，求余 != 0，说明该位置为出现一次的数
            // 然后 << i 位恢复
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {0, 1, 0, 1, 0, 1, 4};
        System.out.println(singleNumber(nums));
    }

}
