package xyz.bugcoder.leetcode_pp.double_pointer;

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-02 23:49
 */
public class singleNonDuplicate_Mid_540 {

    // 思路
    //
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else if (nums[mid] != nums[mid + 1]) {
                r = mid - 1;
            }
        }
        return l;
    }

}
