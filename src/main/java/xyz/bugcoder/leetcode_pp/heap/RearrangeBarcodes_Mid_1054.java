package xyz.bugcoder.leetcode_pp.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Package: xyz.bugcoder.leetcode_pp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-29 21:42
 */
public class RearrangeBarcodes_Mid_1054 {

    // 思路
    //   首先从队列中取出栈顶的两对子，组合肯定不是相同的啦，但是这两对子映射的次数减一重新放回队列中，直到队列中对子少于2对。
    //   如果队列还剩一个对子，那直接放置在输出码末尾
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public int[] rearrangeBarcodes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        // 统计 <编码，次数>
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // 最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int n : map.keySet()) {
            maxHeap.offer(n);
        }

        int[] res = new int[nums.length];
        int index = 0;
        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            res[index++] = a;
            res[index++] = b;
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA > 1) {
                map.put(a, freqA - 1);
                maxHeap.offer(a);
            }
            if (freqB > 1) {
                map.put(b, freqB - 1);
                maxHeap.offer(b);
            }
        }

        // nums 大小为奇数个
        if (maxHeap.size() > 0){
            res[index] = maxHeap.poll();
        }

        return res;
    }

    @Test
    public void test(){
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(rearrangeBarcodes(nums)));
    }

}
