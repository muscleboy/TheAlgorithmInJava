package xyz.bugcoder.leetcode_pp.back_track;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索
// 👍 411 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: weiyj
 * @time 2021-01-18 23:56
 * @desc: todo
 */
public class pathSum_Mid_113 {

    /**
     * 思路
     *    回溯，每次减去当前节点的值
     * 复杂度
     *    时间：O(N)
     *    时间：O(N)
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrack(res, new ArrayList<>(), root, sum);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                // new ArrayList<>(path) 效率慢？
                res.add(new ArrayList(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        backtrack(res, path, root.left, sum - root.val);
        backtrack(res, path, root.right, sum - root.val);
        path.remove(path.size() - 1);
    }

}
