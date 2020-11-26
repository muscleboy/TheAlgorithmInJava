package xyz.bugcoder.leetcode_pp.tree;

//请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 示例:
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/
// Related Topics 树 设计
// 👍 85 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.LinkedList;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-26 15:32
 */
public class CodecTreeByRec_Hard_297 {

    // 递归、前序遍历
    public String serialize(TreeNode root) {

        if (root == null){
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);

        return  root.val + "," + left + "," + right;
    }

    public TreeNode deserialize(String data) {

        // 所有的节点
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.addLast(s);
        }

        return help(nodes);
    }

    public TreeNode help(LinkedList<String> nodes){

        if (nodes.isEmpty()){
            return null;
        }

        String rootStr = nodes.removeFirst();
        if (rootStr.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootStr));
        root.left = help(nodes);
        root.right = help(nodes);

        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        CodecTreeByRec_Hard_297 c = new CodecTreeByRec_Hard_297();
        System.out.println(c.serialize(n1));
        System.out.println(c.deserialize("1,2,#,#,3,4,#,#,5,#,#"));

    }

}
