package xyz.bugcoder.jianzhioffer.LinkedList;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 5373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Package: xyz.bugcoder.jianzhioffer.LinkedList
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-13 11:11
 */
public class AddTwoNum_Mid_2 {

    // 思路
    //   相加时，考虑进位和余数
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 保存结果链表
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        // 进位
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            // 进位
            addOne = sum / 10;
            // 相加可能会超过 10，所以是求余
            head.next = new ListNode(sum % 10);
            head = head.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

}
