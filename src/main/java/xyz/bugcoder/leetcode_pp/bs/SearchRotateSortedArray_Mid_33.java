package xyz.bugcoder.leetcode_pp.bs;

//给你一个整数数组 nums ，和一个整数 target 。
//
// 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
// ）。
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// nums 肯定会在某个点上旋转
// -10^4 <= target <= 10^4
//
// Related Topics 数组 二分查找
// 👍 1078 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 13:08
 */
public class SearchRotateSortedArray_Mid_33 {

    // 思路
    //   收尾双指针 l, r
    //   先根据 nums[0] 和 nums[mid]的大小关系大题判断往左还是往右找
    //   2 3 4 5 6 7 1  nums[l] <= nums[mid] 前半部分有序
    //   nums[0] <= nums[mid] 在左边找，再根据 target >= nums[l] && target <= nums[mid] 缩短右边， 否则缩短左边距离
    //   6 7 1 2 3 4 5  nums[l] > nums[mid] 后半部分有序
    //   nums[0] > nums[mid] 在右边找，再根据 target < nums[l] && target > nums[mid] 缩短左边， 否则缩短右边距离
    // 复杂度
    //   时间：O(logN)
    //   空间：O(1)
    public int search(int[] nums, int target) {

        if (nums.length == 1 && nums[0] != target){
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = (l + r)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[l] <= nums[mid]){
                if (target >= nums[l] && target <= nums[mid]){
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (target < nums[l] && target > nums[target]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

}
