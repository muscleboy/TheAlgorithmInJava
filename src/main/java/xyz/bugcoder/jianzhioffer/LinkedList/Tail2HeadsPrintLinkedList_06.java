package xyz.bugcoder.jianzhioffer.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 44 👎 0

/**
 * @Package: LinkedList
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-08-04 23:25
 */
public class Tail2HeadsPrintLinkedList_06 {

    // 基础写法，用到栈，List，内存和用时 高
    public static int[] reversePrint(ListNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        int size = result.size();
        int[] r = new int[size];
        for (int i = 0; i < size; i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    // 循环链表，得到链表的长度，for倒序循环
    public static int[] reversePrint2(ListNode listNode){
        int len = 0;
        ListNode currentListNode = listNode;
        while (currentListNode != null){
            len ++;
            currentListNode = currentListNode.next;
        }
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            result[i] = listNode.val;
            listNode = listNode.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(Arrays.toString(reversePrint(n1)));
        System.out.println(Arrays.toString(reversePrint2(n1)));
    }

}