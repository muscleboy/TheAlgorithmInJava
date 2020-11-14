package xyz.bugcoder.leetcode_pp.tree;

//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:      1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:     1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:      1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
// Related Topics 树 深度优先搜索
// 👍 509 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-14 09:13
 */
public class IsSameTree_EC_100 {

    // 思路
    //   递归判断根结点、左右子树
    //   null  &&  null   true
    //   null  ||  null   false
    //   val   !=  val    false
    //   递归左右子树
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

        TreeNode m1 = new TreeNode(3);
        TreeNode m2 = new TreeNode(9);
        TreeNode m3 = new TreeNode(20);
        TreeNode m4 = new TreeNode(15);
        TreeNode m5 = new TreeNode(7);
        m1.left = m2;
        m1.right = m3;
        m3.left = m4;
        m3.right = m5;

        System.out.println(isSameTree(n1, m1));
    }

}
