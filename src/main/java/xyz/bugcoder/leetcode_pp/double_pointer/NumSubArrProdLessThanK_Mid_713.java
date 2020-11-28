package xyz.bugcoder.leetcode_pp.double_pointer;

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 11:17
 */
public class NumSubArrProdLessThanK_Mid_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // 不加这个，[1,2,3] 0, 下面 l 会越界
        if(k <= 1){
            return 0;
        }

        // 个数
        int count = 0;
        // 乘积
        int prod = 1;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            prod *= nums[r];
            // >= K, 不满足, 当前的 积 要除以 左指针, 然后做指针右移，直至乘积小于k
            while(prod >= k){
                prod /= nums[l];
                l ++;
            }
            // 每次减去之前的，再累加
            count += r - l + 1;
        }

        return count;
    }

}
