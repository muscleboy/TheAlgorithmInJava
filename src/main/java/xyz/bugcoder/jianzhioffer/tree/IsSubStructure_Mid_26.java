package xyz.bugcoder.jianzhioffer.tree;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
//给定的树 A:
//
// 3
// / \
// 4 5
// / \
// 1 2
//给定的树 B：
//
// 4
// /
// 1
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
// 示例 1：
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
//
//
// 示例 2：
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true
//
// 限制：
//
// 0 <= 节点个数 <= 10000
// Related Topics 树
// 👍 167 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

/**
 * @Package: xyz.bugcoder.jianzhioffer.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-15 12:37
 */
public class IsSubStructure_Mid_26 {

    /**
     * 思路
     *    子结构可能是从根、左、右 开始的，所以递归根、左、右
     * 复杂度
     *    时间：O(MN)
     *    空间：O(M)，M 为主树的节点数，N 为子结构节点数
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSubStructure(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        // 子树有可能是从 根结点、根结点左边、根结点右边 开始的
        return dfs(root1, root2) || isSubStructure(root1.left, root2) || isSubStructure(root1.right, root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        // 此时 root2 已经遍历完了，说明是子树
        if (root2 == null) {
            return true;
        }
        // 当主树都遍历完了 或者 值不相等，那就不可能是子树
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        // root1，root2 都 != null，并且还相等，那就接着判断左右节点
        return dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }

}
