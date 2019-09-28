package xyz.bugcoder.tree;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description: 二叉树的创建
 * @Date: 2019-09-28 11:18
 * @Author: Wyj
 */
public class BinaryTree {

    // 根结点
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void frontShow(){
        root.frontShow();
    }

    public void midShow(){
        root.midShow();
    }

//    public void afterShow(){
//        root.afterShow();
//    }

    public static void main(String[] args) {

        // 创建一颗空的二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 根结点
        TreeNode root = new TreeNode(1);
        binaryTree.setRoot(root);
        // 左右节点
        TreeNode leftNode = new TreeNode(2);
        root.setLeftNode(leftNode);
        TreeNode rightNode = new TreeNode(3);
        root.setRightNode(rightNode);

        // 为第二层的节点再添加左右节点
        leftNode.setLeftNode(new TreeNode(4));
        leftNode.setRightNode(new TreeNode(5));
        rightNode.setLeftNode(new TreeNode(6));
        rightNode.setRightNode(new TreeNode(7));

        // 先序遍历
        root.frontShow();
        System.out.println("=========");
        root.midShow();
        System.out.println("=========");
        root.afterShow();
    }

}
