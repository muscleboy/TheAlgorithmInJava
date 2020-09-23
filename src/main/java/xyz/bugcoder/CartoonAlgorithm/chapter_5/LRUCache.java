package xyz.bugcoder.CartoonAlgorithm.chapter_5;

import java.util.HashMap;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: LRUCache(最近最少使用)算法
 * @createTime 2020-09-23 07:44
 */
public class LRUCache {

    class Node {
        public Node pre;
        public Node next;
        public String key;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String value;
    }

    // 头尾
    public Node head;
    public Node end;
    // 存储上限
    public int limit;

    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }
        // 刷新节点，使用过移动到end
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value){
        Node node = hashMap.get(key);
        if (node == null){
            // 超出limit限制，删除头节点
            if (hashMap.size() >= limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        }else {
            // 存在则更新value
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(node);
    }

    public void refreshNode(Node node){
        // 如果删除的是尾部，则不用删除
        if (node == end){
            return;
        }
        // 删除节点
        removeNode(node);
        // 重新插入到尾部
        addNode(node);
    }

    // 画图好理解
    public String removeNode(Node node){
        // 只有一个节点的情况
        if (node == head && node == end){
            head = null;
            end = null;
            // 删除尾节点
        }else if (node == end){
            end = end.pre;
            end.next = null;
            // 删除头结点
        }else if (node == head){
            head = head.next;
            head.pre = null;
        }else {
            // 中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        return node.key;
    }

    public void addNode(Node node){
        // 尾结点不为null
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        // 尾结点为null
        end = node;
        if (head == null){
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("001", "user 001");
        lruCache.put("002", "user 002");
        lruCache.put("003", "user 003");
        lruCache.get("002");
        lruCache.put("004", "user 004");
        lruCache.put("005", "user 005");
        // 此时，001，003已被删除，为null
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("002"));
        System.out.println(lruCache.get("003"));
        System.out.println(lruCache.get("004"));
        System.out.println(lruCache.get("005"));
    }

}
