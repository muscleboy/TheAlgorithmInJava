package xyz.bugcoder.leetcode_pp.double_pointer;

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 11:52
 */
public class SortedSquares_EC_977 {

    // 思路
    //   收尾双指针，绝对值大的放后边
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public int[] sortedSquares(int[] nums) {

        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int index = len - 1;
        int[] res = new int[len];
        while (index >= 0){
            // 因为它本身就是递增排序的，如果左边的绝对值比右边大，那它的评分一定是最大的，nums[l]的绝对值大
            if (nums[l] + nums[r] < 0){
                nums[index] = nums[l] * nums[l];
                index --;
                l ++;
            }else {
                nums[index] = nums[r] * nums[r];
                index --;
                r --;
            }
        }

        return res;
    }

}
