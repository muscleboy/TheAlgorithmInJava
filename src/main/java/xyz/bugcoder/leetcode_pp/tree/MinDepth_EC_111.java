package xyz.bugcoder.leetcode_pp.tree;

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 423 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-24 10:57
 */
public class MinDepth_EC_111 {

    // 树的最小深度-递归dfs
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        }else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    // 树的最小深度-bfs
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 根结点
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                // 到达终点-叶子节点
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size --;
            }
            depth ++;
        }
        return depth;
    }

}
