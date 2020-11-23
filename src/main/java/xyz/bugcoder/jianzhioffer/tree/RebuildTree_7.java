package xyz.bugcoder.jianzhioffer.tree;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder =  [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;
import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.jianzhioffer.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 11:21
 */
public class RebuildTree_7 {

    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    // 思路
    //   根据前序遍历可以得出 根结点为 preorder[0]
    //   inorder =  [9, 3, 15, 20, 7] 可以拆分为左右子树，然后递归
    // 复杂度
    //   时间：遍历数组 O(N)，递归 O(N), 所以总的还是 O(N)
    //   空间：需要递归操作 N 次，需要的栈空间为 O(N)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // 前序遍历的[0]为 树的根结点
        // 需要根据中序遍历来确定左右子树
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return rec(0, 0, inorder.length - 1);
    }

    public TreeNode rec(int root, int left, int right){
        if (left > right){
            return null;
        }
        // 根结点为 preorder[0]
        TreeNode rootNode = new TreeNode(preorder[root]);
        // 这里的 index 为根结点在在中序遍历中的 位置(下标)
        int index = map.get(preorder[root]);
        // 参数 root 部分：根据前序遍历
        // left、right 部分：根据中序遍历
        rootNode.left = rec(root + 1, left, index - 1);
        // 前序遍历 preorder = [3, 9, 20, 15, 7]
        //            1       根
        // 中序遍历 inorder =  [9, 3, 15, 20, 7]
        //            2          根
        // 此时有 root = 0, index = 1, left = 0;
        // 那么根据前序遍历，根结点的右节点(20)为： preorder[root + index - left + 1] = preorder[2] = 20
        rootNode.right = rec(root + index - left + 1, index + 1, right);

        return rootNode;
    }

    @Test
    public void test(){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));
    }

}
