package xyz.bugcoder.leetcode_pp.sliding_window;

//在由若干 0 和 1 组成的数组 A 中，有多少个和为 S 的非空子数组。
//
//
//
// 示例：
//
// 输入：A = [1,0,1,0,1], S = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//
//
//
//
// 提示：
//
//
// A.length <= 30000
// 0 <= S <= A.length
// A[i] 为 0 或 1
//
// Related Topics 哈希表 双指针
// 👍 73 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.sliding_window
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-02 10:30
 */
public class NumSubarraysWithSum_Mid_930 {

    // 前缀和？？？
    public static int numSubarraysWithSum(int[] A, int S) {

        if (A == null || A.length == 0){
            return 0;
        }

        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i : A) {
            sum += i;
            if (map.containsKey(sum - S)){
                count += map.get(sum - S);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1,1};
        System.out.println(numSubarraysWithSum(nums, 3));
    }

}
