package xyz.bugcoder.my.hashmap;

import java.util.HashMap;
import java.util.Map;
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
    private Entry<K, V>[] tables;

    int size;
    
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

    public MyHashMap(int cap) {
        this(cap, LOAD_FACTOR);
    }

    public MyHashMap() {
        this.threshold = DEFAULT_INITIAL_CAPACITY;
        this.loadFactor = LOAD_FACTOR;
    }

    // 返回一个 >= 当前数(cap)的2的次方数
    // cap = 8-1=7  1110
    // 1110 >>> 1
    private static int tableSizeFor(int cap){
        // -1: 会得到 >= cap
        // 不减: 2*cap
        int h = cap;
        System.out.println(Integer.toBinaryString(h));
        h |= h >>> 1;
        System.out.println(Integer.toBinaryString(h));
        h |= h >>> 2;
        System.out.println(Integer.toBinaryString(h));
        h |= h >>> 4;
        System.out.println(Integer.toBinaryString(h));
        h |= h >>> 8;
        System.out.println(Integer.toBinaryString(h));
        h |= h >>> 16;
        System.out.println(Integer.toBinaryString(h));
        return (h < 0) ? 1 : (h >= MAX_CAPACITY) ? MAX_CAPACITY : h + 1;
    }

    static class Entry<K, V> implements MyEntry<K, V> {

        int hash;
        K key;
        V value;
        // 链表
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
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

    public V put(K key, V value){

        if (key == null){
            return putForNullKey(value);
        }

        int hash = hash(key.hashCode());
        System.out.println("k: " + key + ", v: " + value);
        System.out.println("hash: " + hash);
        int index = indexFor(hash, tables.length);
        System.out.println("index: " + index);
        // 遍历链表
        for (Entry<K, V> e = tables[index]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || k.equals(key))){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(hash, key, value, index);

        return null;
    }

    // 求余
    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    // 处理空Key
    private V putForNullKey(V value) {
        for (Entry<K, V> e = tables[0]; e != null ; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(0, null, value, 0);
        return null;
    }

    private void addEntry(int hash, K k, V v, int bucketIndex) {
        Entry<K, V> e = tables[bucketIndex];
        tables[bucketIndex] = new Entry<>(hash, k, v, e);
        
        if (size ++ > threshold)
            resize(tables.length << 1);
        
    }

    // 数组部分扩容
    private void resize(int cap) {

        Entry[] oldTable = tables;
        int oldCap = tables.length;
        if (oldCap == MAX_CAPACITY){
            threshold = Integer.MAX_VALUE;
            return;
        }

        // todo resize
        // todo transfer

    }

    // 计算hash值
    private int hash(Object key){
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }



    public static void main(String[] args) {
//        MyHashMap<String, Integer> m = new MyHashMap();
//        m.put("a", 1);
//        m.put("b", 2);
//        m.put("c", 3);
//        m.put("d", 4);
//        System.out.println(m.hash("b"));
        tableSizeFor(16);
    }

}
