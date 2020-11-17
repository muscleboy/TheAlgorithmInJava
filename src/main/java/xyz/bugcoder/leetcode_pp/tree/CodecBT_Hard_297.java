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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-17 10:47
 */
public class CodecBT_Hard_297 {

    // 思路
    //   BFS层序遍历，遇到 null 就 append "null," 非 null 就是 append "val,"
    // 复杂度
    //   时间：O(N)，需要遍历树所有节点
    //   空间：O(W)，需要长度为树最大宽度 W 的队列
    public static String serialize(TreeNode root){

        if (root == null) {
            return "[]";
        }

        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null){
                res.append(temp.val).append(",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }else {
                res.append("null,");
            }
        }

        // [1,2,3,null,null,4,5,null,null,null,null,]  去掉最后这个,
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // 也是bfs层序遍历，复杂度和序列化一样
    public static TreeNode deserialize(String data){

        if (data.equals("[]")){
            return null;
        }

        // 去掉首尾的[]
        String[] str = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> queue = new LinkedList<>(Arrays.asList(root));

        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!str[i].equals("null")){
                node.left = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(node.left);
            }
            i ++;
            if (!str[i].equals("null")){
                node.right = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(node.right);
            }
            i ++;
        }

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
        System.out.println(serialize(n1));
        System.out.println(deserialize(serialize(n1)));
    }

}
