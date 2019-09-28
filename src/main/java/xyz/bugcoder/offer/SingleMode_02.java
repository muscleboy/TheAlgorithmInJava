package xyz.bugcoder.offer;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.offer
 * @Description: 单例模式-02
 *              设计一个类，我们只能生成该类的一个实例。
 * @Date: 2019/9/12 17:05
 * @Author: Wyj
 */
// 饿汉式单例模式（不管需不需要都加载）
//    1. 私有化构造函数
//    2. 静态实例instance指向构造函数
//    3. public static的getInstance()
//public class SingleMode_02 {
//
//    private SingleMode_02() {
//    }
//
//    public static SingleMode_02 instance = new SingleMode_02();
//
//    public static SingleMode_02 getInstance(){
//
//        return instance;
//    }
//
//}

//懒汉式单例模式
//  1. 私有化构造函数
//  2. 静态实例instance指向构造函数
//  3. public static的getInstance()，如果对象为空则加载，否则直接返回instance
public class SingleMode_02 {

    private SingleMode_02(){

    }

    public static SingleMode_02 instance = new SingleMode_02();

    public static SingleMode_02 getInstance(){

        if (instance == null)
            instance = new SingleMode_02();
        return instance;
    }

}
