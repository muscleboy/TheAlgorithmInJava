package xyz.bugcoder.leetcode_pp.tree;

import xyz.bugcoder.leetcode_pp.TreeNode;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索
// 👍 836 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-26 17:28
 */
public class IsValidBST_Mid_98 {

    // 判断是否为二叉搜索树
    // 思路
    //   dfs，不过要注意右子树左节点的取值范围
    //   当前节点的值为 左子树的上限
    //   当前节点的值为 右子树的下限
    // 复杂度
    //   时间：O(logN)
    //   空间：O(logN)，递归栈空间
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, Integer minVal, Integer maxVal) {
        //
        if (root == null){
            return true;
        }

        //    5
        //   / \
        //  1   8
        //     / \
        //    6   9

        // 如这里的6，一定要 5 < 6 < 8
        // 所以这里 直接反向判断
        if (root.val <= minVal || root.val >= maxVal){
            return false;
        }

        return isValidBST(root, minVal, root.val) && isValidBST(root, root.val, maxVal);
    }

    // 这里有个坑，就是右子树左节点的范围问题，以下为 错误代码！！！！
    public boolean isValidBST_Wrong(TreeNode root){
        if (root == null){
            return true;
        }
        if ((root.left == null && root.right.val > root.val) || (root.right == null && root.left.val < root.val)){
            return true;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

}
