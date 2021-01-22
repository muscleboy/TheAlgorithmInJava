package xyz.bugcoder.jianzhioffer.array;

//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
//
//
//
//
//
//
// 示例 1：
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
//
//
// 示例 2：
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
//
//
// 示例 3：
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
//
//
// 示例 4：
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// 0 <= A[i] <= 9
// 0 <= K <= 10000
// 如果 A.length > 1，那么 A[0] != 0
//
// Related Topics 数组
// 👍 96 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: weiyj
 * @time 2021-01-22 09:36
 * @desc: todo
 */
public class addToArrayForm_Ec_989 {

    /**
     * 思路
     *    逐位相加，满 10 进 1
     * 复杂度
     *    时间：O(max(nums.length, k))
     *    空间：O(1)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm(int[] nums, int k) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();

        // 倒序，正常加
        for (int i = len - 1; i >= 0; i--) {
            int sum = nums[i] + k % 10;
            k /= 10;
            if (sum >= 10) {
                k ++;
                sum -= 10;
            }
            res.add(sum);
        }

        // k 是余数 或者 len < k 的长度
        for (; k > 0; k /= 10) {
            res.add(k % 10);
        }
        Collections.reverse(res);

        return res;
    }

    @Test
    public void test(){
        int[] nums = {2, 1, 5};
        int k = 43;
        System.out.println(addToArrayForm(nums, k));
    }

}
