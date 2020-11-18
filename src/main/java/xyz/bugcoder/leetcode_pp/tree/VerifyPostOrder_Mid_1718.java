package xyz.bugcoder.leetcode_pp.tree;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
// 👍 144 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.tree
 * @author: Weiyj
 * @Description: 对应 剑指offer 33
 * @createTime 2020-11-18 18:21
 */
public class VerifyPostOrder_Mid_1718 {


    // 思路
    //   二叉搜索树：left  < root
    //             right > root
    // 复杂度
    //   时间：每次折半, O(logN)
    //   空间：O(1) ?
    public static boolean verifyPostorder(int[] postorder) {

        return postOrder(postorder, 0, postorder.length - 1);
    }

    public static boolean postOrder(int[] arr, int l, int r){
        if (l >= r){
            return true;
        }
        // 后序遍历根结点为最后一个
        int root = arr[r];
        int i = 0;
        // 1,3,2,6,5
        // 找到小于根结点的最后一个位置(右子树的开始下标)
        for (; i < r; i++) {
            if (arr[i] > root)
                break;
        }

        // 右子树中还存在比根结点小的，则不满足
        int j;
        for (j = i; j < r; j++) {
            if (arr[j] < root)
                return false;
        }

        // 分治左右子树、递归
        // 下次这个位置为递归的头结点，所以要右边都要 -1
        return postOrder(arr, l, i - 1) && postOrder(arr, i, r - 1);
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1,3,2,6,5}));
        System.out.println(verifyPostorder(new int[]{1,6,3,2,5}));
    }

}
