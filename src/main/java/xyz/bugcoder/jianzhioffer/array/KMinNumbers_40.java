package xyz.bugcoder.jianzhioffer.array;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法
// 👍 156 👎 0

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-30 10:51
 */
public class KMinNumbers_40 {

    // TopK问题，堆
    // NlogK
    public static int[] kMinNumbers(int[] nums, int k){

        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return new int[]{};
        }

        // 优先队列(大顶堆), 默认是小顶堆
        Queue<Integer> q = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int n : nums) {
            if (q.size() < k){
                // Stack.push()
                q.offer(n);
            }else if(n < q.peek()){
                // 等同Stack.pop()，出现比它还小的，则去掉这个数，最后得到的就是Top K
                q.poll();
                q.offer(n);
            }
        }

        int[] res = new int[q.size()];
        int index = 0;
        for (int n : q) {
            res[index++] = n;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,1};
        System.out.println(Arrays.toString(kMinNumbers(nums, 3)));
    }

}
