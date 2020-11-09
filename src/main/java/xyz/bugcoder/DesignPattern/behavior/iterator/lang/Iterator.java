package xyz.bugcoder.DesignPattern.behavior.iterator.lang;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.iterator.lang
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-08 15:12
 */
public interface Iterator<E> {

    boolean hasNext();  // 是否有下一个

    E next();   // 获取下一个

}
