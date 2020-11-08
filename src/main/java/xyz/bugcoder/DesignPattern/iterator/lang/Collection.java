package xyz.bugcoder.DesignPattern.iterator.lang;

/**
 * @Package: xyz.bugcoder.DesignPattern.iterator.lang
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-08 15:14
 */

// 定义集合操作接⼝； Collection ，同时继承了另外⼀个接⼝ Iterable 的⽅法 iterator() 。
// 这样后续谁来实现这个接⼝，就需要实现上述定义的⼀些基本功能； 添加元素 、 删除元素 、 遍历 。
// 同时这⾥定义了两个泛型 <E, L> ，因为我们的数据结构⼀个是⽤于添加元素，另外 ⼀个是⽤于添加树节点的链路关系。
public interface Collection<E, L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String k, L l);

    boolean removeLink(String k);

    Iterator<E> iterator();

}
