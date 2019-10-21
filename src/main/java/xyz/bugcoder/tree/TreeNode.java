package xyz.bugcoder.tree;

import java.util.LinkedList;

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

        System.out.print(value + " ");
        if (leftNode != null){

            leftNode.frontShow();
        }
        if (rightNode != null){

            rightNode.frontShow();
        }
    }

    // 前序查找
    public TreeNode frontSearch(int i){

        TreeNode target = null;
        if (this.value == i)
            return this;
        else {

            if (leftNode != null)
                target = leftNode.frontSearch(i);

            if (target != null)
                return target;

            if (rightNode != null)
                target = rightNode.frontSearch(i);
        }

        return target;
    }

    // 中序遍历
    public void midShow(){

        if (leftNode != null) {

            leftNode.midShow();
        }
        System.out.print(value + " ");
        if (rightNode != null) {

            rightNode.midShow();
        }
    }

    @Override
    public String toString() {
        return ""+this.value;
    }

    // 中序查找
    public TreeNode midSearch(int i){

        TreeNode target = null;

        if (this.leftNode != null){
            target = this.leftNode.midSearch(i);
        }else {

            if (this.value == i)
                return this;

            if (this.rightNode != null)
                target = this.rightNode.midSearch(i);
        }

        return target;
    }

    // 后序遍历
    public void afterShow(){

        if (leftNode != null) {

            leftNode.afterShow();
        }
        if (rightNode != null) {

            rightNode.afterShow();
        }
        System.out.print(value + " ");
    }

    // 删除一个节点
    public void delete(int i) {
        TreeNode parent = this;
        //判断左儿子
        if(parent.leftNode != null&&parent.leftNode.value == i) {
            parent.leftNode = null;
            return;
        }
        //判断右儿子
        if(parent.rightNode != null&&parent.rightNode.value == i) {
            parent.rightNode =  null;
            return;
        }

        //递归检查并删除左儿子
        parent = leftNode;
        if(parent != null) {
            parent.delete(i);
        }

        //递归检查并删除右儿子
        parent = rightNode;
        if(parent != null) {
            parent.delete(i);
        }
    }

    // 层序遍历二叉树;
    public void levelTraverse(TreeNode root){

        // 将LinkedList用作队列，利用队列的先进先出遍历
        LinkedList<TreeNode> list = new LinkedList<>();
        // 将根结点入队
        list.offer(root);
        // 记录当前节点
        TreeNode current;
        while (!list.isEmpty()) {
            // 先进先出
            current = list.poll();
            System.out.print(current.value + " ");
            if (current.leftNode != null)
                // 左节点入队
                list.offer(current.leftNode);
            if (current.rightNode != null)
                // 右节点入队
                list.offer(current.rightNode);
        }

    }

    // 后序查找
//    public TreeNode afterSearch(int i){
//
//        TreeNode target = null;
//        if (leftNode.value == i){
//
//            return this;
//        }else {
//
//            if (rightNode != null)
//                target = rightNode.afterSearch(i);
//
//            if (target != null)
//                return target;
//
//            if (this != null)
//                target = this.afterSearch(i);
//        }
//
//        return target;
//    }

}
