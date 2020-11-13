package xyz.bugcoder.leetcode_pp.tree;

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-13 08:41
 */
public class GetMaxDepth_EC_104 {

    // 思路
    //   无限递归左右子树，返回大的一边
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static int dfs(TreeNode node){

        if (node == null){
            return 0;
        }

        int l = dfs(node.left) + 1;
        int r = dfs(node.right) + 1;

        return Math.max(l, r);
    }

    public static int bfs(TreeNode root){

        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth ++;
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size --;
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        System.out.println(dfs(n1));
        System.out.println(bfs(n1));
    }

}
