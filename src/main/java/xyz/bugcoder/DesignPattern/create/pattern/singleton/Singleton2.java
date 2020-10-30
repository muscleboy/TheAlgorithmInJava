package xyz.bugcoder.DesignPattern.create.pattern.singleton;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.pattern.singleton
 * @author: Weiyj
 * @Description: 单例模式-懒汉式(线程不安全)
 * @createTime 2020-10-24 17:11
 */

// 单例模式-懒汉式(线程不安全)
// 1.达到了lazy loading的效果，但只能在单线程的情况下使用
// 2.多线程情况下，可能会产生多个对象实例，已经不符合单例模式的要求
//public class Singleton2 {
//
//    // 1.私有化构造函数
//    private Singleton2() {
//    }
//
//    // 2.成员变量
//    private static Singleton2 instance;
//
//    // 3.public方法获取实例
//    public static Singleton2 getInstance(){
//
//        if (instance == null){
//            instance = new Singleton2();
//        }
//
//        return instance;
//    }
//
//}


// 单例模式-懒汉式(线程安全)
// 1.解决了线程不安全问题
// 2.带来的问题：效率太低，每个线程在想要获得实例时，执行getInstance方法都要同步，而实际上只需要执行一次实例化，后面直接return instance就可以了
//public class Singleton2 {
//
//    // 1.私有化构造函数
//    private Singleton2() {
//    }
//
//    // 2.成员变量
//    private static Singleton2 instance;
//
//    // 3.public方法获取实例，方法加了同步，线程安全
//    public static synchronized Singleton2 getInstance(){
//
//        if (instance == null){
//            instance = new Singleton2();
//        }
//
//        return instance;
//    }
//
//}

// 本意是解决synchronized同步方法效率低的问题，但是结果连 线程安全都达不到
public class Singleton2 {

    // 1.私有化构造函数
    private Singleton2() {
    }

    // 2.成员变量
    private static Singleton2 instance;

    public static Singleton2 getInstance(){

        if (instance == null){
            // 3.public方法获取实例，同步代码块 -> 线程不安全
            synchronized(Singleton2.class){
                instance = new Singleton2();
            }
        }

        return instance;
    }

}