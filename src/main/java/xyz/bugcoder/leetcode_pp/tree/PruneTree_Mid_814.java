package xyz.bugcoder.leetcode_pp.tree;

//给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
//
// 返回移除了所有不包含 1 的子树的原二叉树。
//
// ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
//
//
//示例1:
//输入: [1,null,0,0,1]
//输出: [1,null,0,null,1]
//
//解释:
//只有红色节点满足条件“所有不包含 1 的子树”。
//右图为返回的答案。
//
//
//
//
//
//示例2:
//输入: [1,0,1,0,0,0,1]
//输出: [1,null,1,null,1]
//
//
//
//
//
//
//示例3:
//输入: [1,1,0,1,1,0,1,0]
//输出: [1,1,0,1,1,null,1]
//
//
//
//
//
// 说明:
//
//
// 给定的二叉树最多有 100 个节点。
// 每个节点的值只会为 0 或 1 。
//
// Related Topics 树
// 👍 126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-18 11:26
 */

// 树的剪枝
public class PruneTree_Mid_814 {

    // 思路
    //   递归，左右节点为 null，且根结点为 0，则剪枝(置空)
    // 复杂度
    //   时间：O(N)，N 为节点数
    //   空间：O(N)
    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

}
