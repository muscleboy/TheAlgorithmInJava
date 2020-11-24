package xyz.bugcoder.concurrent.heima_5_JMM;

import java.io.Serializable;

/**
 * @Package: xyz.bugcoder.concurrent.heima_5_JMM
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 17:29
 */

// 1.为什么加 final
//   防止子类覆盖父类的方法，破坏单例
// 2.如果实现了序列化，还需要做什么来防止反序列破坏单例
//    见答案 2
public final class SingletonExcercise implements Serializable {

    // 3.为什么设置私有，是否能防止反射创建新的实例
    //   私有是防止外部 new 生成实例；但还是能通过反射创建新的实例
    private SingletonExcercise(){}

    // 4.静态变量在类初始化时完成，类加载时由 JVM 保证线程安全
    private static final SingletonExcercise instance = new SingletonExcercise();

    // 5.为什么是通过提供 public 方法，而不是直接将 instance 设置为 public？
    //     更好的封装性，隐藏细节
    //     方法能够支持泛型
    //     方法能够实现懒加载
    public static SingletonExcercise getInstance(){
        return instance;
    }

    // 答案 2
    public Object readResolve(){
        return instance;
    }

}
