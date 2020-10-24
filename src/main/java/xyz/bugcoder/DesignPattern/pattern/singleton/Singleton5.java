package xyz.bugcoder.DesignPattern.pattern.singleton;

/**
 * @Package: xyz.bugcoder.DesignPattern.pattern.singleton
 * @author: Weiyj
 * @Description: 单例模式-枚举
 * @createTime 2020-10-24 18:11
 */

// 1.线程安全，只会加载一次
public class Singleton5 {

    public static void main(String[] args) {
        SingletonInstance instance = SingletonInstance.INSTANCE;
        SingletonInstance instance2 = SingletonInstance.INSTANCE;
        instance2.hello();
        // true
        System.out.println(instance == instance2);
        // true
        System.out.println(instance.hashCode() == instance2.hashCode());
    }

}

enum SingletonInstance{

    INSTANCE;

    public void hello(){
        System.out.println("hello");
    }

}
