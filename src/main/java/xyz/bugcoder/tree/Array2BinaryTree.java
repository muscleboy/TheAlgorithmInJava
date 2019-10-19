package xyz.bugcoder.tree;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description: 把一个数组当成二叉树来遍历
 * @Date: 2019-10-19 20:21
 * @Author: Wyj
 */
public class Array2BinaryTree {

    int data[];

    public Array2BinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow(){
        frontShow(0);
    }

    // 先序遍历
    public void frontShow(int index){
        if (data.length == 0 || data == null){

            return;
        }
        // 先遍历当前节点
        System.out.print(data[index] + " ");
        // 当前节点的左节点
        if (2*index + 1 < data.length){
            frontShow(2*index + 1);
        }
        // 当前节点的右节点
        if (2*index + 2 < data.length){
            frontShow(2*index + 2);
        }
    }

    // 中序遍历
    public void midShow(){
        midShow(0);
    }
    // 中序遍历
    public void midShow(int index){
        if (data.length == 0 || data == null){

            return;
        }
        // 当前节点的左节点
        if (2*index + 1 < data.length){
            midShow(2*index + 1);
        }
        // 先遍历当前节点
        System.out.print(data[index] + " ");
        // 当前节点的右节点
        if (2*index + 2 < data.length){
            midShow(2*index + 2);
        }
    }

    // 后序遍历
    public void afterShow(){
        afterShow(0);
    }
    // 后序遍历
    public void afterShow(int index){
        if (data.length == 0 || data == null){

            return;
        }
        // 当前节点的左节点
        if (2*index + 1 < data.length){
            afterShow(2*index + 1);
        }
        // 当前节点的右节点
        if (2*index + 2 < data.length){
            afterShow(2*index + 2);
        }
        // 先遍历当前节点
        System.out.print(data[index] + " ");
    }

}
