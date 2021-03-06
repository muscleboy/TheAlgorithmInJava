package xyz.bugcoder.leetcode_pp.tree;

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.*;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-04 10:11
 */
public class PreOrder_Mid_144 {

    static List<Integer> res = new ArrayList<>();

    // 二叉树前序遍历--递归
    public static List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root){
        if (root == null){
            return;
        }
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    // 二叉树前序遍历--迭代
    // 1.根结点
    // 2.左结点
    // 3.右结点
    public static List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // 1.取根节点
                res.add(root.val);
                stack.push(root);
                // 2.遍历左子树
                root = root.left;
            }else {
                TreeNode temp = stack.pop();
                // 3.遍历右子树
                root = temp.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        // [1, 2, 4, 5, 3, 6, 7]
//        System.out.println(preorderTraversal(n1));
        // [1, 2, 4, 5, 3, 6, 7]
        System.out.println(preorderTraversal2(n1));
    }

}
