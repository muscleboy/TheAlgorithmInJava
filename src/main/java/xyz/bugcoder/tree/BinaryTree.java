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
        if (root != null){

            root.frontShow();
        }
        System.out.println("空");
    }

    public void frontSearch(int i){

        root.frontSearch(i);
    }

    public void midShow(){
        if (root != null){

            root.midShow();
        }
        System.out.println("空");
    }

    public void midSearch(int i){

        root.midSearch(i);
    }

    public void delete(int i) {

        if(root.value == i) {
            root = null;
        }else {
            root.delete(i);
        }
    }

    public void afterShow(){
        if (root != null){

            root.afterShow();
        }
        System.out.println("空");
    }
}
