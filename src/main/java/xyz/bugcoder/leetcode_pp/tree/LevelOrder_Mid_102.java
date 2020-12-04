package xyz.bugcoder.leetcode_pp.tree;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 695 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.*;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-15 11:06
 */
public class LevelOrder_Mid_102 {

    // 思路
    //   二叉树的层序遍历，每一层new一个List
    // 复杂度
    //   时间: O(N)
    //   空间: O(N)
    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            // 每次都是一个新的List
            List<Integer> temp = new ArrayList<>();
            // size为每一层的节点数
            while (size > 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            result.add(temp);
        }

        return result;
    }

    // 层序遍历-递归
    // 思路
    //   每次递归带上当前节点的层数，如果是该层第一个节点，该层对应的list 还未创建，则 add([])
    // 复杂度
    //   时间：O(N)
    //   空间：O(h),最多需要长度为 h 的 List
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, root, res);
        return res;
    }

    private static void dfs(int index, TreeNode root, List<List<Integer>> res){
        // 假设 index = 3，res = [[1],[2,3]]
        // add 之后 [[1],[2,3][]]
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        // 假设 index = 3, res = [[1],[2,3],[4]]，进来的节点root是 5,
        // add之后，[[1],[2,3],[4,5]]
        res.get(index - 1).add(root.val);
        // 左、右子树都是下一层
        if (root.left != null){
            dfs(index + 1, root.left, res);
        }
        if (root.right != null) {
            dfs(index + 1, root.right, res);
        }
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

        System.out.println(levelOrder(n1));
        System.out.println(levelOrder2(n1));
    }

}
