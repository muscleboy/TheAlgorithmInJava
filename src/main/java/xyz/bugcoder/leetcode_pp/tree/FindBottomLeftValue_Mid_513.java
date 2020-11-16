package xyz.bugcoder.leetcode_pp.tree;

//给定一个二叉树，在树的最后一行找到最左边的值。
//
// 示例 1:
//
//
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
//
//
//
//
// 示例 2:
//
//
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
//
//
//
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 131 👎 0

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-16 09:27
 */
public class FindBottomLeftValue_Mid_513 {

    // 思路
    //   迭代法，层序遍历每一次都记录该层最左边的值
    // 复杂度
    //   时间：O(N), N为节点数据
    //   时间：O(W)，需要长度为树的最大宽度的队列
    public static int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                // 记录上一次最左边的值
                if (i == 0){
                    res =  node.val;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }

        return res;
    }

    // 思路
    //   BFS遍历是 从上到下，左到右，但如果是 从右到左，那最后一个元素就是最下边、最左边的
    // 复杂度
    //   时间：O(N)，需要遍历每个节点
    //   时间：O(W)，需要长度为树的最大宽度的队列
    public static int findBottomLeftValue2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;

        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.right != null){
                queue.offer(node.right);
            }
            if (node.left != null){
                queue.offer(node.left);
            }
        }

        return node.val;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        System.out.println(findBottomLeftValue(n1));
    }

}
