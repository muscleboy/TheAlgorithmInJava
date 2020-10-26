package xyz.bugcoder.jianzhioffer.array;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//
//
// 示例 1：
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
//
//
// 示例 2：
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2]
//
//
//
// 限制：
//
//
// 2 <= nums.length <= 10000
//
//
//
// 👍 245 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-26 10:38
 */
public class SingleNumbers_56 {

    // 题目要求  时间复杂度是O(n)，空间复杂度是O(1)，所以不能用排序...
    // 异或运算
    public static int[] singleNumbers(int[] nums){

        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        int xorResult = 0;
        for (int n : nums) {
            xorResult ^= n;
        }

        // =0,说明没有出现奇数次(1)的数，不符合题意
        // != 0, 说明xorResult至少有一位为 1
        if (xorResult == 0){
            return new int[]{};
        }

        //  这里是找到为 1 的那一位，下面用做分组
        int div = 1;
        while ((xorResult & div) == 0){
            div <<= 1;
        }

        int a = 0,b = 0;
        for (int n : nums) {
            if ((div & n) == 0){
                a ^= n;
            }else {
                b ^= n;
            }
        }

        return new int[]{a,b};
    }

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
//
//
// 示例 1：
//
// 输入：nums = [3,4,3,3]
//输出：4
//
//
// 示例 2：
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10000
// 1 <= nums[i] < 2^31
//
//
//
// 👍 93 👎 0

    public static int singleNumbers2(int[] nums){

        if (nums == null || nums.length == 0){
            return -1;
        }

        // nums中的每一位的二进制数 各个位之和
        // nums: [9,9,1,9]
        // 1001
        // 1001
        // 0001
        // 1001
        // 3004
        int[] count = new int[4];
        for (int n : nums) {
            for (int j = 0; j < 4; j++) {
                count[j] += n & 1;
                n >>>= 1;
            }
        }

        // 理通顺了，但还是不懂恢复....
        int res = 0, m = 3;
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            res <<= 1;
            temp = count[3 - i] % m;
            res |= temp;
        }

        return res;
    }

    // 理解不了，还是用HashMap吧....
    public static int singleNumbers3(int[] nums){

        if (nums == null || nums.length == 0){
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else {
                map.put(n, 1);
            }
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1)
                return m.getKey();
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,10,4,1,4,3,3};
//        System.out.println(Arrays.toString(singleNumbers(nums)));
        int[] nums = new int[]{9,3,7,9,7,9,7};
//        System.out.println(singleNumbers2(nums));
        System.out.println(singleNumbers3(nums));
    }

}
