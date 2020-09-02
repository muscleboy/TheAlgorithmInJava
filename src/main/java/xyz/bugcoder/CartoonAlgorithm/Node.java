package xyz.bugcoder.CartoonAlgorithm;

import java.util.*;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CartoonAlgorithm
 * @Description:
 * @Date: 2020-08-13 01:13
 * @Author: Wyj
 */
public class Node {

    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    // 通过链表构建二叉树
    public static Node createBinaryTree(LinkedList<Integer> list){
        if (list == null || list.size() == 0)
            return null;
        Node node = null;
        Integer integer = list.removeFirst();
        if (integer != null){
            node = new Node(integer);
            node.left = createBinaryTree(list);
            node.right = createBinaryTree(list);
        }

        return node;
    }

    // 递归前序遍历二叉树
    public static void preOrderTravelWithRecursive(Node root){
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTravelWithRecursive(root.left);
        preOrderTravelWithRecursive(root.right);
    }

    // 非递归遍历前序遍历二叉树
    public static void preOrderTravelWithStack(Node root){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    // 递归中序遍历二叉树
    public static void midOrderTravelWithRecursive(Node root){
        if (root == null)
            return;
        midOrderTravelWithRecursive(root.left);
        System.out.print(root.data + " ");
        midOrderTravelWithRecursive(root.right);
    }

    // 非递归中序遍历二叉树
    public static void midOrderTravelWithStack(Node root){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    // 递归后序遍历
    public static void postOrderTravelWitchRecursive(Node root){
        if (root == null)
            return;
        postOrderTravelWitchRecursive(root.left);
        postOrderTravelWitchRecursive(root.right);
        System.out.print(root.data + " ");
    }

    // 非递归后续遍历
    public static void postOrderTravelWithStack(Node root){
        Deque<Node> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            Node node = deque.pop();
            if (node != null) {
                result.add(node.data);
                deque.push(node.left);
                deque.push(node.right);
            }
        }
        // 前序：左子树(包括根结点), 右子树
        // 先右子树(包括根结点), 左子树， 然后反转
        Collections.reverse(result);
        System.out.println(result);
    }

    // 二叉树层序遍历
    public static void levelOrderTravel(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 4, null, null, 5, null, null, 3, null, 6));
        Node node = createBinaryTree(linkedList);
        preOrderTravelWithStack(node);
        System.out.println();
        preOrderTravelWithRecursive(node);
        System.out.println();
        midOrderTravelWithRecursive(node);
        System.out.println();
        midOrderTravelWithStack(node);
        System.out.println();
        postOrderTravelWitchRecursive(node);
        System.out.println();
        postOrderTravelWithStack(node);
        System.out.println();
        levelOrderTravel(node);
    }

}
