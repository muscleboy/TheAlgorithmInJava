package xyz.bugcoder.leetcode_pp.linkedlist;

//给定一个链表，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。
//
//
//
// 进阶：
//
// 你能用 O(1)（即，常量）内存解决此问题吗？
//
//
//
// 示例 1：
//
//
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 104]
// -105 <= Node.val <= 105
// pos 为 -1 或者链表中的一个 有效索引 。
//
// Related Topics 链表 双指针
// 👍 847 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;
import xyz.bugcoder.leetcode_pp.ListNode;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 10:51
 */
public class DetectCycle_Mid_142 {

    // 思路
    //   D: 头结点到入环点
    //   S1 入环点到相遇点
    //   S2 相遇点回到入环点， S1 + S1 = 1圈
    //   首次相遇时，n1走了 D + S1
    //   首次相遇时，n2走了 D + S1 + n-1(S1+S2)
    //   n2的速度是n1的两倍， 所以：2(D + S1) = D + S1 + n-1(S1+S2)
    //   根据双指针到相遇点走的距离，可以推导出 -> 头结点到入环点的距离 = 相遇点到入环点的距离
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static ListNode getEntryNode(ListNode head){

        ListNode n1 = head;
        ListNode n2 = head;
        while (n2 != null && n2.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
            // 相遇
            if (n1 == n2){
                ListNode temp = head;
                // 头结点到入环点的距离 = 相遇点到入环点的距离
                while (temp != n1){
                    n1 = n1.next;
                    temp = temp.next;
                }
                return temp;
            }
        }

        return null;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(8);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n4;

        System.out.println(getEntryNode(n1));
    }

}
