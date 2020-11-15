package xyz.bugcoder.leetcode_pp.tree;

//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
// 计算从根到叶子节点生成的所有数字之和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25.
//
// 示例 2:
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026.
// Related Topics 树 深度优先搜索
// 👍 285 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-15 08:54
 */
public class SumNumber_Mid_129 {

    // 思路
    //   路径和是将叶子节点直接拼接到根结点后面，所以到当前节点的路径和 = 根结点 * 10 + 当前节点.val
    //   然后dfs左右节点
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int preSum){
        if (node == null) {
            return 0;
        }

        // 叶子节点的路径和 = 根结点 * 10 + 叶子.val
        int sum = preSum * 10 + node.val;
        if (node.left == null && node.right == null){
            return sum;
        }

        return dfs(node.left, sum) + dfs(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(sumNumbers(n1));
    }

}
