package xyz.bugcoder.leetcode_pp.tree;

//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 406 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-26 14:15
 */

// 知道中、后序遍历，构造出二叉树
public class InPostBuildTree_Mid_106 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){

        //
        if (inStart > inEnd){
            return null;
        }

        // 根结点值
        int rootVal = postorder[postEnd];
        //  根据根结点值，获取到其在中序遍历数组中的 下标
        int index = map.get(rootVal);
        // 根据下标算出 左子树的节点数
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        // 根据左子树节点数，可以从前序遍历确定 起始位置
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

}
