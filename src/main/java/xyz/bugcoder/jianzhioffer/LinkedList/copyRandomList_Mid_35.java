package xyz.bugcoder.jianzhioffer.LinkedList;

//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// 示例 2：
//
//
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//
// 示例 3：
//
//
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
//
// 示例 4：
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
//
//
//
//
// 提示：
//
//
// -10000 <= Node.val <= 10000
// Node.random 为空（null）或指向链表中的节点。
// 节点数目不超过 1000 。
//
//
//
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/
//
//
// Related Topics 链表
// 👍 134 👎 0

import java.util.HashMap;

/**
 * @Package: xyz.bugcoder.jianzhioffer.LinkedList
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-16 11:28
 */
public class copyRandomList_Mid_35 {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 思路
     *    1.先构建 原链表 和 新链表 的对应关系，
     *    2.在遍历新链表，处理 next 和 random
     * 复杂度
     *    时间：O(N)
     *    空间：O(N)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 1.
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 2.
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

}

