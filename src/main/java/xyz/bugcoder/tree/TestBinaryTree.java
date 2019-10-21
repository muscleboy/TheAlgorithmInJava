package xyz.bugcoder.tree;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description:
 * @Date: 2019-10-19 19:31
 * @Author: Wyj
 */
public class TestBinaryTree {

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
//        System.out.println(root.frontSearch(3));
//        System.out.println(root.midSearch(3));
//        root.levelTraverse(root);
//        root.midShow();
//        // 是二叉树的删除，不是root删除。。
//        binaryTree.delete(1);
//        System.out.println();
//        binaryTree.midShow();
        System.out.println(binaryTree.frontSearch(5));
    }

}
