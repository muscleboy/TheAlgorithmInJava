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

    public void frontSearch(int i){

        root.frontSearch(i);
    }

    public void midShow(){
        root.midShow();
    }

    public void midSearch(int i){

        root.midSearch(i);
    }

    public void afterShow(){
        root.afterShow();
    }

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
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);

        leftNode.setLeftNode(ll);
        leftNode.setRightNode(lr);
        rightNode.setLeftNode(rl);
        rightNode.setRightNode(rr);

        // 先序遍历
//        root.frontShow();
//        System.out.println("=========");
//        root.midShow();
//        System.out.println("=========");
//        root.afterShow();
//        System.out.println(root.frontSearch(8));
        System.out.println(root.midSearch(7));
        System.out.println(lr);
    }

}
