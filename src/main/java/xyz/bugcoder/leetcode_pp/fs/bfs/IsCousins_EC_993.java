package xyz.bugcoder.leetcode_pp.fs.bfs;

//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
//
//
// 示例 2：
//
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
//
//
// 示例 3：
//
//
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false
//
//
//
// 提示：
//
//
// 二叉树的节点数介于 2 到 100 之间。
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。
//
//
//
// Related Topics 树 广度优先搜索
// 👍 113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.fs.bfs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-24 12:25
 */
public class IsCousins_EC_993 {

    // 思路
    //   bfs层序遍历，记录 x,y节点、以及其父节点 xNode, yNode
    //   一层遍历结束，① x, y 节点都为 null, 继续
    //              ② x, y 节点都不为 null，比较他们的父节点
    //              ③ 只找到一边，那肯定不是堂兄弟节点了
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)，N 为节点数
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode xNode = null;
        TreeNode yNode = null;
        TreeNode xFather = null;
        TreeNode yFather = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        xNode = node.left;
                        xFather = node;
                    }
                    if (node.left.val == y) {
                        yNode = node.left;
                        yFather = node;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        xNode = node.right;
                        xFather = node;
                    }
                    if (node.right.val == y) {
                        yNode = node.right;
                        yFather = node;
                    }
                }
                if (xNode == null && yNode == null) {
                    continue;
                }
                // xy 节点都找到，判断他们是不是堂兄弟节点
                else if (xNode != null && yNode != null) {
                    // != 就是堂兄弟
                    return xFather != yFather;
                }
                // 能走到这，说明只找到一边，那肯定不是堂兄弟节点了
                else if (size == 0) {
                    return false;
                }
            }
        }
        return false;
    }

}
