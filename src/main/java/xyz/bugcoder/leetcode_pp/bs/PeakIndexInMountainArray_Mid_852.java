package xyz.bugcoder.leetcode_pp.bs;

//我们把符合下列属性的数组 A 称作山脉：
//
//
// A.length >= 3
// 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[
//A.length - 1]
//
//
// 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.leng
//th - 1] 的 i 的值。
//
//
//
// 示例 1：
//
// 输入：[0,1,0]
//输出：1
//
//
// 示例 2：
//
// 输入：[0,2,1,0]
//输出：1
//
//
//
// 提示：
//
//
// 3 <= A.length <= 10000
// 0 <= A[i] <= 10^6
// A 是如上定义的山脉
//
//
//
// Related Topics 二分查找
// 👍 127 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.bs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-05 12:32
 */
public class PeakIndexInMountainArray_Mid_852 {

    // 思路
    //   根据 nums 的递增、递减，缩小搜索范围
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int peakIndexInMountainArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 递增
            if (nums[mid + 1] > nums[mid]) {
                l = mid + 1;
            }
            // 递减
            else if (nums[mid - 1] > nums[mid]) {
                r = mid - 1;
            }
            // 找到了峰顶
            else {
                return mid;
            }
        }
        return -1;
    }

}
