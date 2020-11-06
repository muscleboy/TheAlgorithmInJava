package xyz.bugcoder.leetcode_pp.array;

//数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连
//接的结果和按升序排序后的原数组相同。
//
// 我们最多能将数组分成多少块？
//
// 示例 1:
//
// 输入: arr = [4,3,2,1,0]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
//
//
// 示例 2:
//
// 输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0] [2], [3], [4] 可以得到最多的块数。
//
//
// 注意:
//
//
// arr 的长度在 [1, 10] 之间。
// arr[i]是 [0, 1, ..., arr.length - 1]的一种排列。
//
// Related Topics 数组
// 👍 98 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-06 10:00
 */
public class MaxChunksToSorted_Mid_769 {

    public static int maxChunksToSorted(int[] nums){

        if (nums == null || nums.length == 0){
            return 0;
        }

        int count = 0;
        int max = 0;
        // 当遍历到第i个位置时，如果可以切分为块，那前i个位置的最大值一定等于i。
        // 否则，一定有比i小的数划分到后面的块，那块排序后，一定不满足升序。
        // 因为这是[0,n-1]的数组，当num[i]位置为当前的最大值，并且num[i]要等于 i, 不然连接之后和原数组不一致
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max == i){
                count ++;
            }
        }

        return count;
    }

}
