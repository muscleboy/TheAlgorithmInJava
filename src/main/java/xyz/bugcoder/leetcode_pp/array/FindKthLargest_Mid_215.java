package xyz.bugcoder.leetcode_pp.array;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法
// 👍 790 👎 0

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-20 12:12
 */
public class FindKthLargest_Mid_215 {

    // 思路
    //   直接堆排序
    // 复杂度
    //   时间：遍历 O(N)，堆化 logK
    //   空间：O(N)
    public static int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0){
            return -1;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            if (queue.size() < k){
                queue.offer(i);
            }else if (i > queue.peek()){
                queue.poll();
                queue.offer(i);
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

}
