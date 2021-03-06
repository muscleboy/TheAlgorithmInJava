package xyz.bugcoder.leetcode_pp.tree;

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-04 10:37
 */
public class InOrder_Mid_94 {

    List<Integer> res = new ArrayList<>();

    // 中序遍历-递归
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    // 中序遍历-迭代
    // 1.左节点
    // 2.根节点
    // 3.右节点
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // 1.遍历左节点
                stack.push(root);
                root = root.left;
            }else {
                TreeNode temp = stack.pop();
                // 2.取根节点
                res.add(temp.val);
                // 3.遍历右节点
                root = temp.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        InOrder_Mid_94 in = new InOrder_Mid_94();
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
        // [4, 2, 5, 1, 6, 3, 7]
//        System.out.println(in.inorderTraversal(n1));
        // [4, 2, 5, 1, 6, 3, 7]
        System.out.println(in.inorderTraversal2(n1));
    }

}
