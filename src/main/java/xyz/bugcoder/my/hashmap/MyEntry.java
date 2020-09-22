package xyz.bugcoder.my.hashmap;

/**
 * @Package: xyz.bugcoder.my.hashmap
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-09-03 23:29
 */
public interface MyEntry<K, V> {

    K getKey();
    V getValue();
    V setValue(V value);
    boolean equal(Object o);
    int hashcode();
    String toString();

}
