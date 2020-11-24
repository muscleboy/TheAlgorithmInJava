package xyz.bugcoder.concurrent.heima_5_JMM;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 17:52
 */

// 枚举单例
public enum  EnumSingleton {

    instance;

}

// Q1: 枚举单例是如何控制实例个数的？
//     通过反编译可知，继承自 java.lang.Enum， 就是类的一个静态成员变量

// Q2: 枚举单例在创建时是否有并发问题
//     也静态成员变量，在类加载的时候完成，是线程安全的

// Q3: 枚举单例是否能被反射、反序列化 破坏单例？
//     不能；   enum 默认都是实现了序列化接口，可以被序列化、反序列化，但是不能被反序列化破坏单 例
