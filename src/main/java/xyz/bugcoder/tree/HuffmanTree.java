package xyz.bugcoder.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description: 创建哈夫曼树🌲
 * @Date: 2019-10-21 09:31
 * @Author: Wyj
 */
public class HuffmanTree implements Comparable<HuffmanTree>{

    // 左右节点
    HuffmanTree leftNode;
    HuffmanTree rightNode;
    // 权值
    int value;

    public HuffmanTree(int value) {
        this.value = value;
    }

    /**
    * @Description: 创建哈夫曼树
    * @Param: [arr]
    * @return: xyz.bugcoder.tree.HuffmanTree
    */
    // 给定一个数组，创建一颗哈夫曼树
    public static HuffmanTree createHuffmanTree(int[] arr){

        List<HuffmanTree> nodes = new ArrayList<>();
        // 先使用所有节点创建若干个二叉树(只有一个节点的二叉树)
        for (int i : arr) {
            nodes.add(new HuffmanTree(i));
        }
        // 排序
        Collections.sort(nodes);
        // 当size=1时，说明已经创建好了一颗哈夫曼树了
        while (nodes.size() > 1){

            // 取出权值最小的2颗二叉树
            HuffmanTree left = nodes.get(nodes.size() - 1);
            HuffmanTree right = nodes.get(nodes.size() - 2);
            // 将取出来的2颗二叉树组成新的二叉树, 根结点的权值为：左右节点的权值之和
            HuffmanTree parent = new HuffmanTree(left.value + right.value);
            // 设置左右节点，只是为了方便遍历验证结果,不是创建哈夫曼树的步骤
            parent.leftNode = left;
            parent.rightNode = right;
            // 将取出来的2颗二叉树从List移除
            nodes.remove(left);
            nodes.remove(right);
            // 将新创建的二叉树添加到数组中
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    /**
    * @Description: 先序遍历
    * @Param: []
    * @return: void
    */
    public void frontShow(){

        System.out.print(value + " ");

        if (leftNode != null)
            leftNode.frontShow();

        if (rightNode != null)
            rightNode.frontShow();
    }

    // 中序遍历，查看创建好的哈夫曼树是怎样的
    public void midShow(){

        if (leftNode != null)
            leftNode.midShow();

        System.out.print(value + " ");

        if (rightNode != null)
            rightNode.midShow();
    }

    @Override
    public String toString() {
        return this.value + " ";
    }

    @Override
    public int compareTo(HuffmanTree o) {
        // -：表示 大到小排序
        return -(this.value - o.value);
    }

    public static void main(String[] args) {
        // 给定一个数组
        int[] arr = new int[]{3,5,7,8,11,14};
        // 创建一颗Huffman树
        HuffmanTree node = createHuffmanTree(arr);
        System.out.println(node.value);
        node.frontShow();
        System.out.println();
        node.midShow();
    }

}
