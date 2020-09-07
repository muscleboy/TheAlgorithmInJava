package xyz.bugcoder.my.hashmap;

import java.util.Objects;

/**
 * @Package: xyz.bugcoder.my
 * @author: Weiyj
 * @Description: HashMap实现
 * @createTime 2020-09-03 23:24
 */
public class MyHashMap<K, V> {

    // 数组
    private Node<K, V>[] tables;

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


}
