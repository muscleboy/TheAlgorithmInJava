package xyz.bugcoder.jianzhioffer.array;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1：
//
// 输入：[3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
// 输入：[2,2,2,0,1]
//输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/
// Related Topics 二分查找
// 👍 169 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-29 11:58
 */
public class MinArray {

    public static int minArray(int[] nums){

        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int m = (left + right)/2;
            // > : 说明最小值一定在m的右边, 如{3,4,5,1,2}
            if (nums[m] > nums[right]){
                left = m + 1;
            }
            // {3,1,3}, m不能-1, 因为m可能就是最小值
            else if (nums[m] < nums[right]){
                right = m;
            }
            // {3,1,3,3,3}, {3,3,3,1,3}，此时无法知道在m的左边，还是右边，但可以减少范围
            else {
                right --;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(minArray(nums));
    }

}
