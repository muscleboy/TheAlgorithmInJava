package xyz.bugcoder.tree;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description:
 * @Date: 2019-10-19 20:29
 * @Author: Wyj
 */
public class TestArray2BinaryTree {

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7};
        Array2BinaryTree tree = new Array2BinaryTree(data);
        tree.frontShow();
        System.out.println();
        tree.midShow();
        System.out.println();
        tree.afterShow();
    }

}
