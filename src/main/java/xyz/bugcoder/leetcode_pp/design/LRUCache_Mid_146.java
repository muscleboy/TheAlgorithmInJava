package xyz.bugcoder.leetcode_pp.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.linkedlist
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 09:00
 */
public class LRUCache_Mid_146 {

    class Node{
        Node pre;
        Node next;
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node end;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache_Mid_146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        // 删除节点
        removeNode(node);
        // 再添加到尾部
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null){
            // 超过容量，删除头结点
            if (map.size() >= capacity){
                int oldKey = removeNode(head);
                map.remove(oldKey);
            }
            // 添加新节点
            node = new Node(key, value);
            map.put(key, node);
            addNode(node);
        }
        // 更新旧节点(删除、再添加)
        node.value = value;
        removeNode(node);
        addNode(node);
    }

    // 1.只有一个节点
    // 2.删除的是 头
    // 3.删除的是 尾
    // 4.删除的是 中间节点
    public int removeNode(Node node){
        if (node == head && node == end){
            head = null;
            end = null;
        }else if (node == head){
            head = head.next;
            head.pre = null;
        }else if (node == end){
            end = end.pre;
            end.next = null;
        }else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        return node.key;
    }

    // 添加节点到尾部
    public void addNode(Node node){
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        // 第一个节点
        if (head == null){
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache_Mid_146 lruCache = new LRUCache_Mid_146(3);
        lruCache.put(2, 100);
        lruCache.put(2, 200);
        lruCache.put(2, 300);
//        lruCache.get(2);
//        lruCache.put(4, 400);
//        lruCache.put(5, 500);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
//        System.out.println(lruCache.get(5));
    }

}

