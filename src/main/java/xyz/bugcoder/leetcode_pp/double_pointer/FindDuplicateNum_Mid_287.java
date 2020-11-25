package xyz.bugcoder.leetcode_pp.double_pointer;

//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。
//
// 示例 1:
//
// 输入: [1,3,4,2,2]
//输出: 2
//
//
// 示例 2:
//
// 输入: [3,1,3,4,2]
//输出: 3
//
//
// 说明：
//
//
// 不能更改原数组（假设数组是只读的）。
// 只能使用额外的 O(1) 的空间。
// 时间复杂度小于 O(n2) 。
// 数组中只有一个重复的数字，但它可能不止重复出现一次。
//
// Related Topics 数组 双指针 二分查找
// 👍 971 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 09:47
 */
public class FindDuplicateNum_Mid_287 {

    // 思路
    //   和 求环形链表的入环点一毛一样，先找相遇点，slow 从头开始，fast 从相遇点开始，
    //   速度一样的走，再相等时，就是重复点
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 快慢指针
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            // 快指针，根据题意并不会越界
            fast = nums[nums[fast]];
        }while (slow != fast);

        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

}
