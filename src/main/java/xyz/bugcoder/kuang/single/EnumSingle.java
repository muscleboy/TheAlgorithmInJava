package xyz.bugcoder.kuang.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Package: xyz.bugcoder.kuang.single
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 20:05
 */

// 枚举单例
public enum  EnumSingle {

    instance;

    public EnumSingle getInstance() {
        return instance;
    }

}

class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        EnumSingle instance1 = EnumSingle.instance;
//        EnumSingle instance2 = EnumSingle.instance;
//
//        System.out.println(instance1);
//        System.out.println(instance2);

        // 尝试用反射破坏枚举单例
        // java.lang.NoSuchMethodException: xyz.bugcoder.kuang.single.EnumSingle.<init>()
        // 说明 idea 对代码进行了一些修改
        // 然后通过 javap -p EnumSingle，发现也是有空参构造函数

        // 最终通过 jad -sjava EnumSingle.class 得到 Java 原文件
        // 发现其中有一个 构造器 super(String, int)
        // 所以这里需要对构造器参数改为 getDeclaredConstructor(String.class, int.class)
        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        // Cannot reflectively create enum objects  无法通过反射破坏枚举单例
        EnumSingle instance = constructor.newInstance();
    }
}
