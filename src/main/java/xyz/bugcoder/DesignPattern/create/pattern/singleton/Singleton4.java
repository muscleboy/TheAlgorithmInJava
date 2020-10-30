package xyz.bugcoder.DesignPattern.create.pattern.singleton;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.pattern.singleton
 * @author: Weiyj
 * @Description: 单例模式-静态内部类
 * @createTime 2020-10-24 17:43
 */

// 优缺点：
// 1.采用类装载机制来保证初始化实例只有一个线程, 所以是线程安全的
// 2.静态内部类在外部类被装载的时候并不会立即实例化，而是在需要的时候实例化，调用getInstance才会装载内部类, 完成实例化
// 3.类是静态属性只会在第一次加载的时候初始化，这里JVM保证线程的安全性，在类进行初始化时，别的线程是无法进入的
// 4.优点：线程安全，延迟加载，效率高, 推荐写法
public class Singleton4 {

    private Singleton4(){}

    // 静态内部类中实例化
    private static class Inner{
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {

        return Inner.instance;
    }
}
