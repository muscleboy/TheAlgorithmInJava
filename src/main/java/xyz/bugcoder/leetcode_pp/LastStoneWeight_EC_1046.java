package xyz.bugcoder.leetcode_pp;

//有一堆石头，每块石头的重量都是正整数。
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//
// 如果 x == y，那么两块石头都会被完全粉碎；
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
//
//
//
// 示例：
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
//
//
//
// 提示：
//
//
// 1 <= stones.length <= 30
// 1 <= stones[i] <= 1000
//
// Related Topics 堆 贪心算法
// 👍 96 👎 0

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Package: xyz.bugcoder.leetcode_pp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-25 10:32
 */
public class LastStoneWeight_EC_1046 {

    // 思路
    //   优先队列，大的优先出去，如果出去的两个数不相等，则放入这两个数的差；相等，意味着这两抵消了
    // 复杂度
    //   时间：O(NlogN)
    //   空间：O(N)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) {
            queue.add(n);
        }
        while (queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            if (a > b){
                queue.add(a - b);
            }
        }

        return queue.size() == 0 ? 0 : queue.poll();
    }

    @Test
    public void test(){
        int[] nums = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(nums));
    }

}
