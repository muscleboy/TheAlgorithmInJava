package xyz.bugcoder.leetcode_pp.tree;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树
// 👍 579 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-31 20:37
 */
public class diameterOfBT_Ec_543 {

    // 此时的路径 = l + r
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 左右子树的高度
        int l = dfs(root.left);
        int r = dfs(root.right);
        // 二叉树的直径：左子树最大高度 + 右子树最大高度
        res = Math.max(res, l + r);
        return Math.max(l, r) + 1;
    }

}
