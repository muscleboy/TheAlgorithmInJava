package xyz.bugcoder.DesignPattern.create.pattern.singleton;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.pattern.singleton
 * @author: Weiyj
 * @Description: 单例模式-双重检查
 * @createTime 2020-10-24 17:34
 */

// 双重检查，线程安全，是懒加载，效率高, 实际开发推荐写法
public class Singleton3 {

    private Singleton3(){}

    // volatile关键字：更改后立即写入到内存中
    private static volatile Singleton3 instance;

    // 双重检查，线程安全，是懒加载，效率高, 推荐写法
    public static synchronized Singleton3 getInstance() {

        if (instance == null){
            synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }

        return instance;
    }
}
