package xyz.bugcoder.leetcode_pp.double_pointer;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//
// 示例 1:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
//
//
// 示例 2:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false
//
// 进阶:
//
//
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
//
// Related Topics 数组 二分查找
// 👍 251 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 13:08
 */
public class SearchRotateSortedArray_Mid_81 {

    // 思路
    //   收尾双指针 l, r
    //   10111 和 111011111 这种, 跳过重复的数
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
            // 跳过重复的项，其他的都一样
            if (nums[l] == nums[mid]){
                l ++;
                continue;
            }
            if (nums[l] <= nums[mid]){
                if (target >= nums[l] && target <= nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (target < nums[l] && target > nums[target]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

}
