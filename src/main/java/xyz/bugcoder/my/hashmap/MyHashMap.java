package xyz.bugcoder.my.hashmap;

import java.util.Arrays;
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

    // 扩容阈值: 数组长度 * 负载因子
    // 当HashMap中元素个数(size)超过这个threshold，进行扩容
    int threshold;

    // 负载因子
    // 计算HashMap的实时负载因子 size/capacity
    float loadFactor;

    // 数组
    private Entry<K, V>[] table;

    // 节点(Node)或者叫Entry(键值对)的数量
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
        table = new Entry[initialCapacity];
    }

    public MyHashMap(int cap) {
        this(cap, LOAD_FACTOR);
    }

    public MyHashMap() {
        this.threshold = DEFAULT_INITIAL_CAPACITY;
        this.loadFactor = LOAD_FACTOR;
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    // 返回一个 >= 当前数(cap)的2的次方数
    // cap = 8-1=7  1110
    // 1110 >>> 1
    private static int tableSizeFor(int cap){
        // -1: 会得到 >= cap
        // 不减: 2*cap
        int h = cap - 1;
//        System.out.println(Integer.toBinaryString(h));
        h |= h >>> 1;
        h |= h >>> 2;
        h |= h >>> 4;
        h |= h >>> 8;
        h |= h >>> 16;
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

        @Override
        public String toString() {
            return "Entry{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

    }

    public V put(K key, V value){

        // 初始化
        if (table == null || table.length == 0) {
            new MyHashMap<>();
        }

        // 处理null key，放在table[0]
        if (key == null){
            return putForNullKey(value);
        }

        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        // 遍历链表
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || e.key.equals(key))){
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
        for (Entry<K, V> e = table[0]; e != null ; e = e.next) {
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

        if (size >= threshold && (table[bucketIndex] != null)){
            // 扩容
            resize(2 * table.length);
            hash = (k == null) ? 0 : hash(k);
            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, k, v, bucketIndex);
        
    }

    private void createEntry(int hash, K k, V v, int index){
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(hash, k, v, e);
        size ++;
    }

    // 数组扩容
    private void resize(int newCap) {

        Entry[] oldTable = table;
        int oldCap = table.length;
        if (oldCap == MAX_CAPACITY){
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCap];
        transfer(newTable);
        table = newTable;
        threshold = (int) Math.min(newCap * LOAD_FACTOR, MAX_CAPACITY + 1);

    }


    private void transfer(Entry[] newTable){
        // 新容量
        int newCap = newTable.length;
        // 遍历原来的是数组
        for (Entry<K, V> e : table) {
            while (e != null){
                Entry<K, V> next = e.next;
                // 新数组hash值
                e.hash = e.key == null ? 0 : hash(e.key);
                // 新数组中的下标
                int index = indexFor(e.hash, newCap);
                e.next = newTable[index];
                newTable[index] = e;
                e = next;
            }
        }
    }

    // get
    private V get(K key){

        // Entry个数
        if (size == 0){
            return null;
        }

        int hash = key == null ? 0 : hash(key);
        // 遍历table数组
        for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || key != null)){
                return e.value;
            }
        }

        return null;

    }

    // 计算hash值
    private int hash(Object key){
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "threshold=" + threshold +
                ", loadFactor=" + loadFactor +
                ", table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> m = new MyHashMap(4);
        m.put("a", 1);
        m.put("b", 2);
        m.put("c", 3);
        m.put("d", 4);
        m.put("e", 5);
        m.put("f", 6);
        m.put("g", 7);
        m.put("h", 8);
        m.put("i", 9);
        m.put("k", 10);
        m.put("kk", 11);
        m.put("kk", 11);
        System.out.println(m);
        System.out.println(m.table.length);
        System.out.println(m.size);
//        MyHashMap<String, String> m2 = new MyHashMap(4);
//        m2.put("K1", "V1");
//        m2.put("K2", "V2");
//        m2.put("K3", "V3");
//        System.out.println(m2);
    }

}
