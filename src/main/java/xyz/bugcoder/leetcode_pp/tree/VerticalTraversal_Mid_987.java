package xyz.bugcoder.leetcode_pp.tree;

//给定二叉树，按垂序遍历返回其结点值。
//
// 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
//
// 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）
//。
//
// 如果两个结点位置相同，则首先报告的结点值较小。
//
// 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
//
//
//
// 示例 1：
//
//
//
// 输入：[3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
//解释：
//在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)：
//然后，值为 9 的结点出现在 (-1, -1)；
//值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)；
//值为 20 的结点出现在 (1, -1)；
//值为 7 的结点出现在 (2, -2)。
//
//
// 示例 2：
//
//
//
// 输入：[1,2,3,4,5,6,7]
//输出：[[4],[2],[1,5,6],[3],[7]]
//解释：
//根据给定的方案，值为 5 和 6 的两个结点出现在同一位置。
//然而，在报告 "[1,5,6]" 中，结点值 5 排在前面，因为 5 小于 6。
//
//
//
//
// 提示：
//
//
// 树的结点数介于 1 和 1000 之间。
// 每个结点值介于 0 和 1000 之间。
//
// Related Topics 树 哈希表
// 👍 62 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import xyz.bugcoder.leetcode_pp.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-18 12:04
 */
public class VerticalTraversal_Mid_987 {

    // 记录每个节点以及其坐标的[]
    private static List<int[]> positionList = new ArrayList<>();

    // 思路
    //   看懂题目！！！， 看了好久才看懂题目，得出题目要点: 排序，按 X 小到大排，X 相等再按 val 小到大排
    // 复杂度
    //   时间：dfs O(N) + 排序 O(NlogN)？
    //   空间：O(N)
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        // dfs 计算每个节点的 x,y 坐标
        dfs(root, 0, 0);
        // 排序，按 X 小到大排，X 相等, 按 Y 大到小排，Y相等，再按val 小到大排
        positionList.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]){
                return b[1] - a[1];
            }
            return a[2] - b[2];
        });

        List<List<Integer>> res = new ArrayList<>();
        int pre = positionList.get(0)[0];
        res.add(new ArrayList<>());
        // 迭代，遇到 与上一个!=的数，就添加一个空的list，然后往这个空的list 添加对应的 val,
        //      遇到 与上一个==的数，就加入到相同的 list 中
        for (int[] arr : positionList) {
            if (pre != arr[0]){
                pre = arr[0];
                res.add(new ArrayList<>());
            }
            res.get(res.size() - 1).add(arr[2]);
        }

        return res;
    }

    public static void dfs(TreeNode root, int x, int y){
        if (root != null){
            dfs(root.left, x - 1, y -1);
            dfs(root.right, x + 1, y -1);
            positionList.add(new int[]{x, y, root.val});
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(verticalTraversal(n1));
    }

}
