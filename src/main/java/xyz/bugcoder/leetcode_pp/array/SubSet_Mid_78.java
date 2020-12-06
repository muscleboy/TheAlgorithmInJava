package xyz.bugcoder.leetcode_pp.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-06 10:39
 */
public class SubSet_Mid_78 {

    // 思路
    //   每循环一个数，就把res 中所有子集都加上这个数
    // 复杂度
    //   时间：O(n * 2^n)
    //   空间：O(1)
    public static List<List<Integer>> subSet(int[] nums){
        // 防止扩容
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        // 空集
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(n);
                res.add(list);
            }
        }

        return res;
    }

    // 思路
    //   数组中每一位数字，都有选(1)和不选(0)的状态，根据数组中数字的二进制位决定，0：未选中，1：选中、记录
    // 复杂度
    //   时间：O(n * 2^n)
    //   空间：O(1)
    public static List<List<Integer>> subSet2(int[] nums){
        int len = 1 << nums.length;
        // 预估长度，防止扩容
        List<List<Integer>> res = new ArrayList<>(len);
        // 2^n, 根据 1 的位置寻找子集
        for (int i = 0; i < len; i++) {
            List<Integer> list = new ArrayList<>();
            // n
            for (int j = 0; j < nums.length; j++) {
                // 位置为 1，选中
                if (((i >> j) & 1) == 1){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }

        return res;
    }

}
