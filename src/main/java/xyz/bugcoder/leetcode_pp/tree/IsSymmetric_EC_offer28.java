package xyz.bugcoder.leetcode_pp.tree;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
//3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树
// 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-19 11:38
 */
public class IsSymmetric_EC_offer28 {

    // 思路
    //   dfs递归  left == null && right == null  true
    //           left == null || right == null  false
    //           left.val != right.val          false
    // 复杂度
    //   时间：O(N), N 为节点数，每次 dfs 就能判断左右节点是否对称，最多调用 N/2 次
    //   空间：O(N), 当二叉树退化成链表，最差需要 N 次递归
    public static boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }

    // 代码结构和 是否相同的数 的递归一致!!!
    public static boolean dfs(TreeNode left, TreeNode right){

        if (left == null && right == null){
            return true;
        }else if (left == null || right == null){
            return false;
        }else if (left.val != right.val){
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    // 思路
    //   bfs 左左、右右、左右、右左 成对
    // 复杂度
    //   时间：O(N)
    //   空间间：O(N)
    public static boolean isSymmetric_bfs(TreeNode root) {

        if (root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null){
                return true;
            }
            // false 和 dfs 判断一样
            if (left == null || right == null || left.val != right.val){
                return false;
            }
            // 顺序很重要!!
            //    1
            //  /   \
            //  2    2
            // / \   / \
            // 3  4  4  3
            // 左左、右右、左右、右左
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(isSymmetric(n1));
        System.out.println(isSymmetric_bfs(n1));
    }

}
