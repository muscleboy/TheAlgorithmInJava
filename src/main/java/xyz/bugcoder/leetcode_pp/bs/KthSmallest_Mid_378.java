package xyz.bugcoder.leetcode_pp.bs;

//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
//
//
//
// 示例：
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
//
//
//
//
// 提示：
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
// Related Topics 堆 二分查找
// 👍 504 👎 0

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-28 11:09
 */
public class KthSmallest_Mid_378 {

    // 思路
    //   topK 直接堆, 要寻找第 k 小的数，那就保存 k 个最小值，
    //   此时的最大值就是 要寻找第 k 小的数
    // 复杂度
    //   时间：O(n²logk)
    //   空间：O(logk)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int[] row : matrix) {
            for (int c : row) {
                if (queue.size() == k && c > queue.peek()){
                    break;
                }
                queue.offer(c);
                if (queue.size() > k) {
                    queue.remove();
                }
            }
        }
        return queue.remove();
    }

    // 思路
    //   第 k 个小元素，那说明 小于等于它的元素一共有 k 个，大于它的数字有 n*n-k 个
    //   左上为最小值，右下为最大值
    // 复杂度
    //   时间：O(2nlog(max - min)), 每次查找2*n, 二分查找的次数log(max - min)
    //   空间：O(1)
    public int kthSmallest2(int[][] matrix, int k) {
        int len = matrix.length - 1;
        int l = matrix[0][0];
        int r = matrix[len][len];
        while (l < r) {
            int mid = (l + r) / 2;
            // 小于mid 的个数
            int count = countNotMoreThan(matrix, mid, len);
            // 小于mid 的个数 < k，往右边找
            if (count < k) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

    // 计算 <= mid 的元素个数
    // 最坏需要寻找 2*n 次
    public int countNotMoreThan(int[][] matrix, int mid, int n) {
        int count = 0;
        int row = 0, col = n;
        while (row <= n && col >= 0) {
            // 从右上角开始找
            if (matrix[row][col] <= mid) {
                count += col + 1;
                row++;
            }
            else {
                col--;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
        System.out.println(kthSmallest2(matrix, k));
    }

}
