package xyz.bugcoder.leetcode_pp.tree;

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树
// 👍 180 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-26 14:49
 */
public class FindDuplicateSubTree_Mid_652 {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        reverse(root);
        return res;
    }

    public String reverse(TreeNode root){
        if (root == null){
            return "#";
        }

        // 后序遍历序列化
        String left = reverse(root.left);
        String right = reverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        Integer freq = map.getOrDefault(subTree, 0);
        // 只记录一次
        if (freq == 1){
            res.add(root);
        }
        map.put(subTree, freq + 1);

        return subTree;
    }

    public static void main(String[] args) {

        FindDuplicateSubTree_Mid_652 f = new FindDuplicateSubTree_Mid_652();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;

        System.out.println(f.findDuplicateSubtrees(n1));
    }

}
