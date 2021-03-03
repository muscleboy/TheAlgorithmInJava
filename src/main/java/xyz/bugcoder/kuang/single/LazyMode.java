package xyz.bugcoder.kuang.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Package: xyz.bugcoder.kuang.single
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 19:39
 */

// 懒汉式单例模式
// 1.懒加载
// 2.非线程安全
public class LazyMode {

    // new 一个对象，在 JVM 层面并不是原子性操作，包括如下步骤
    // 1. 分配内存空间
    // 2. 执行构造方法，初始化对象
    // 3. 把这个对象指向这个空间
    // 使用 volatile 修饰，可以防止指令重排
    private static volatile LazyMode instance;

    private LazyMode() {
//        System.out.println(Thread.currentThread().getName() + " ok...");
    }

    // 通过多线程测试，发现并不是线程安全的(出现多个单例模式，明显和单例模式相悖)
//    public static LazyMode getInstance() {
//        if (instance == null) {
//            instance = new LazyMode();
//        }
//        return instance;
//    }

    // DCL
    public static LazyMode getInstance() {
        // 指令重排发生时，为 132 顺序的话，
        // 此时另一个线程会到达 最外层的if语句，发现不为空，直接返回 instance 对象
        // 但此时的 instance 是不完整的
        if (instance == null) {
            synchronized (LazyMode.class) {
                if (instance == null) {
                    instance = new LazyMode();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazyMode.getInstance();
//            }).start();
//        }

        // 反射破坏单例模式
        LazyMode instance1 = new LazyMode();
        Constructor<LazyMode> constructor = LazyMode.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyMode instance2 = constructor.newInstance();

        // 2503dbd3
        System.out.println(instance1);
        // 4b67cf4d
        System.out.println(instance2);
    }

}
