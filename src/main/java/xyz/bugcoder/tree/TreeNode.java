package xyz.bugcoder.tree;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description: 二叉树的节点
 * @Date: 2019-09-28 11:18
 * @Author: Wyj
 */
public class TreeNode {

    // 树的权
    int value;
    // 左右节点
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    // 先序遍历
    public void frontShow() {

        System.out.println(value);
        if (leftNode != null){

            leftNode.frontShow();
        }
        if (rightNode != null){

            rightNode.frontShow();
        }
    }

    // 中序遍历
    public void midShow(){

        if (leftNode != null) {

            leftNode.midShow();
        }
        System.out.println(value);
        if (rightNode != null) {

            rightNode.midShow();
        }
    }

    // 后序遍历
    public void afterShow(){

        if (leftNode != null) {

            leftNode.afterShow();
        }
        if (rightNode != null) {

            rightNode.afterShow();
        }
        System.out.println(value);
    }

}
