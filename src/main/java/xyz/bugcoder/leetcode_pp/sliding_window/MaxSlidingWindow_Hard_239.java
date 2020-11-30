package xyz.bugcoder.leetcode_pp.sliding_window;

import java.util.*;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 641 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-30 09:16
 */
public class MaxSlidingWindow_Hard_239 {

    // 思路
    //   窗口大小为 k，每次比较 k 个数，时间复杂度为O((n-k)*k)，会超时
    //   改用双向队列实现，每进来一个元素e，都要保证队头是最大，如果e > 当前队头，就全部出队(pollLast)，
    //   然后让入队，此时e就是队列中最大的数, 根据窗口大小记录最大值； 否则添加到队列尾部(addLast)
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)，借助双向队列
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int index = 0;
        int len = nums.length;
        Deque<Integer> queue = new ArrayDeque<>();

        int[] res = new int[len - k + 1];
        for(int i = 0; i < len; i ++){
            // 队列头和当前 i 相差 i-k，队头就要出队
            if (!queue.isEmpty() && queue.peekFirst() <= i - k){
                queue.pollFirst();
            }
            // 前面比它小的，都要删掉，这时候再添加的话，队头(peekFirst)就是最大值了
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if (i >= k - 1){
                res[index++] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

}
