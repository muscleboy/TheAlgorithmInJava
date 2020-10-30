package xyz.bugcoder.DesignPattern.create.pattern.singleton;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.pattern.singleton
 * @author: Weiyj
 * @Description: 单例模式
 * @createTime 2020-10-24 16:54
 */

// 单例模式-饿汉式
// 1.优点：写法简单，在类装载的时候就完成实例化，避免线程同步问题
// 2.缺点：在类装载的时候就完成实例化, 没有达到lazy loading的效果，如果未使用到这个实例，就会造成内存浪费
// 3.结论：可用，但是可能存在内存浪费问题


//public class Singleton {
//
//    // 1.私有化其构造函数，禁止别的类从外部new
//    private Singleton() {
//    }
//
//    // 2.类内部成员变量创建对象实例
//    private static final Singleton instance = new Singleton();
//
//    // 3.对外提供public方法，返回instance实例
//    public static Singleton getInstance() {
//        return instance;
//    }
//
//    public static void main(String[] args) {
//        Singleton instance = getInstance();
//        Singleton instance2 = getInstance();
//        // true
//        System.out.println(instance == instance2);
//        // true
//        System.out.println(instance.hashCode() == instance2.hashCode());
//    }
//
//}

public class Singleton {

    // 1.私有化其构造函数，禁止别的类从外部new
    private Singleton() {
    }


    // 2.静态代码块中 创建对象实例
    private static Singleton instance;
    static {
        instance = new Singleton();
    }

    // 3.对外提供public方法，返回instance实例
    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = getInstance();
        Singleton instance2 = getInstance();
        // true
        System.out.println(instance == instance2);
        // true
        System.out.println(instance.hashCode() == instance2.hashCode());
    }

}