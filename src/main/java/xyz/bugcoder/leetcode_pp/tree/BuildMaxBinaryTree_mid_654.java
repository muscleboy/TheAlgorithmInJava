package xyz.bugcoder.leetcode_pp.tree;

//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//
// 二叉树的根是数组中的最大元素。
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。
//
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//
//
// 示例 ：
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//
//
//
//
// 提示：
//
//
// 给定的数组的大小在 [1, 1000] 之间。
//
// Related Topics 树
// 👍 216 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-26 12:18
 */
public class BuildMaxBinaryTree_mid_654 {

    // 思路
    //   先遍历数组找出总的最大值，作为根结点，记录根结点在数组中的位置 index，
    //   从 index 左右两个再找出各自的最大值，作为左、右节点
    // 复杂度
    //   时间：O(NlogN)
    //   空间：O(N)，递归栈空间
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int left, int right){

        if (left > right){
            return null;
        }

        // 找出最大值
        int max = Integer.MIN_VALUE;
        int index = 0;
        // 这里要 = ，因为传进来的时候已经 index - 1 了
        for (int i = left; i <= right; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }

        // 最大值为根结点
        TreeNode root = new TreeNode(max);

        // 然后再从 index 左右两边找出各自的最大值，作为左、右节点
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(nums));
    }

}
