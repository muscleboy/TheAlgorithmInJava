package xyz.bugcoder.leetcode_pp.linkedlist;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索
// 👍 521 👎 0

import org.junit.Test;
import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-09 11:10
 */
public class IsBalanced_EC_110 {

    public boolean isBalanced(TreeNode root){

        if (root == null){
            return true;
        }

        // 左右高度差 <= 1  是平衡二叉树
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }

        // 并且左右子树也是平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        int l = getHeight(node.left) + 1;
        int r = getHeight(node.right) + 1;

        return Math.max(l, r);
    }

    @Test
    public void test(){
//        TreeNode n1 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(9);
//        TreeNode n3 = new TreeNode(20);
//        TreeNode n4 = new TreeNode(15);
//        TreeNode n5 = new TreeNode(17);
//
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;

//        getHeight(n1);
        System.out.println(isBalanced(n1));
    }

}
