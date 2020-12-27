package xyz.bugcoder.leetcode_pp.stack;

//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
// Related Topics 栈 哈希表
// 👍 593 👎 0

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Package: xyz.bugcoder.leetcode_pp.stack
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-27 11:59
 */
public class DailyTemperatures_Mid_739 {

    // 思路
    //   暴力法，双层 for，往后遍历比较，记录内层循环 > 外层循环的位置
    // 复杂度
    //   时间：O(N²)
    //   空间：O(1)
    public int[] dailyTemperatures(int[] t) {
        int len = t.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = t[i];
            for (int j = i+1; j < len; j++) {
                if (cur < t[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // 思路
    //   单调栈，栈不为空时，且t[i] > 栈顶，则栈顶出去，让 i 入栈；栈为空，直接入栈
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public int[] dailyTemperatures2(int[] t) {
        int len = t.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && t[i] > t[stack.peek()]){
                int p = stack.pop();
                res[p] = i - p;
            }
            stack.push(i);
        }

        return res;
    }

    @Test
    public void test(){
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(t)));
        System.out.println(Arrays.toString(dailyTemperatures2(t)));
    }

}
