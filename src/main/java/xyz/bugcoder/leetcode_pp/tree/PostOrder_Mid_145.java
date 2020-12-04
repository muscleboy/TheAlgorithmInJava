package xyz.bugcoder.leetcode_pp.tree;

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-04 11:13
 */
public class PostOrder_Mid_145 {

    List<Integer> res = new ArrayList<>();

    // 后序遍历-递归
    public List<Integer> postorderTraversal(TreeNode root){
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }

    // 迭代
    // 1.左节点
    // 2.右节点
    // 3.根节点
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // 1.取根节点
                res.add(root.val);
                stack.push(root);
                // 2.遍历右子树
                root = root.right;
            }else {
                TreeNode temp = stack.pop();
                // 3.遍历左子树
                root = temp.left;
            }
        }
        // 原本是 根、右、左   --->  左、右、根
        Collections.reverse(res);
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
        PostOrder_Mid_145 p = new PostOrder_Mid_145();
        // [4, 5, 2, 6, 7, 3, 1]
        System.out.println(p.postorderTraversal(n1));
        // [4, 5, 2, 6, 7, 3, 1]
//        System.out.println(p.postorderTraversal2(n1));
    }

}
