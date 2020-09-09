package xyz.bugcoder.my.hashmap;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Package: xyz.bugcoder.my
 * @author: Weiyj
 * @Description: HashMap实现
 * @createTime 2020-09-03 23:24
 */
public class MyHashMap<K, V> {

    // 默认长度16 new HashMap()操作，tables默认长度
    static final int DEFAULT_INITIAL_CAPACITY = 1<<4;

    // tables最大的长度
    static final int MAX_CAPACITY = 1<<30;

    // 负载因子
    static final float LOAD_FACTOR = 0.75f;

    // 扩容阈值
    int threshold;

    // 负载因子
    float loadFactor;

    // 数组
    private Node<K, V>[] tables;

    // 构造函数
    public MyHashMap(int initialCapacity, float loadFactor) {
        // 检验参数是否合法
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegal argument initialCapacity: " + initialCapacity);
        }
        if (initialCapacity > MAX_CAPACITY){
            initialCapacity = MAX_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("illegal argument loadFactor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    // 返回一个 >= 当前数(cap)的2的次方数
    static final int tableSizeFor(int cap){
        int h = cap - 1;
        h |= h >>> 1;
        h |= h >>> 2;
        h |= h >>> 4;
        h |= h >>> 8;
        h |= h >>> 16;
        return (h < 0) ? 1 : (h >= MAX_CAPACITY) ? MAX_CAPACITY : h + 1;
    }

    static class Node<K, V> implements MyEntry<K, V> {

        int hash;
        K key;
        V value;
        // 链表
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equal(Object o) {
            if (o == this)
                return true;
            if (o instanceof MyEntry) {
                if (Objects.equals(key, ((MyEntry) o).getKey()) &&
                        Objects.equals(value, ((MyEntry) o).getValue()))
                    return true;
            }
            return false;
        }

        @Override
        public int hashcode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

    public static void main(String[] args) {
        System.out.println(tableSizeFor(1200000000));
    }

}
