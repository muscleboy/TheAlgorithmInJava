package xyz.bugcoder.jianzhioffer.array;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//
//
// 示例 1：
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
//
//
// 示例 2：
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//
//
//
//
// 限制：
//
//
// 1 <= target <= 10^5
//
//
//
// 👍 175 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-01 11:33
 */
public class FindContinuousSequence_57 {

    // 滑动窗口 左闭右开
    // 思路：
    // 1.当sum < target, 右边界右移
    // 2.当sum > target, 左边界右移
    // 3.当sum = target, 输出[i, j)位置的子数组
    // 复杂度分析：时间O(n)，空间O(1)
    public static int[][] findContinuousSequence(int target) {

        // 左右边界、和
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        // 左边界最多会移到中间位置，再往回都是超过target的
        while (i <= target/2){
            if (sum < target){
                // 右边界右移
                sum += j;
                j ++;
            }else if (sum > target){
                // 左边界右移
                sum -= i;
                i ++;
            }else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    // k-i: 因为是从i位置开始的
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界右移
                sum -= i;
                i ++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }

}
