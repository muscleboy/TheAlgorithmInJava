package xyz.bugcoder.my.hashmap;

/**
 * @Package: xyz.bugcoder.my.hashmap
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-09-03 23:29
 */
public interface Entry<K, V> {

    K getKey();
    V getValue();
    void setValue();
    boolean equal(Object o);
    int hashcode();

}
