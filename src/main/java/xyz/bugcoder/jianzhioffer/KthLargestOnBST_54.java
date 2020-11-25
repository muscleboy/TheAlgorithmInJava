package xyz.bugcoder.jianzhioffer;

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.ArrayList;
import java.util.List;

//给定一棵二叉搜索树，请找出其中第k大的节点。
//
//
//
// 示例 1:
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4
//
//
//
// 限制：
//
// 1 ≤ k ≤ 二叉搜索树元素个数
// Related Topics 树
// 👍 90 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.jianzhioffer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 16:03
 */
public class KthLargestOnBST_54 {

    private static List<Integer> list = new ArrayList<>();

    public static int kthLargest(TreeNode root, int k) {

        inOrder(root);
        return list.get(list.size() - k);
    }

    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        System.out.println(kthLargest(n1, 1));
    }

}
