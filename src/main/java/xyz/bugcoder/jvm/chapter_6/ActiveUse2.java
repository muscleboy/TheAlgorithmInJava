package xyz.bugcoder.jvm.chapter_6;

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-25 22:24
 *
 *
 * 主动使用：意味着调用类的<clinit>(), 即执行的类的初始化阶段
 *
 * 1.创建一个类的实例，如 new、反射、克隆、序列化、反序列化
 * 2.当调用类的静态方法，invokestatic 字节码指令
 * 3.使用类、接口的静态字段，getstatic、putstatic指令
 * 4.使用java.lang.reflect 包中的反射类方法，如 Class.forName("com.ali.dubbo")
 * 5.初始化子类，如果发现父类没有初始化，则先初始化父类
 * 6.一个接口定义了 default 方法，那么直接、间接实现该接口的类的初始化，该接口会在其之前在初始化
 * 7.虚拟机启动，用户需要指定一个要执行的类(main)，虚拟机会先初始化这个类
 * 8.初次调用 MethodHandle 实例，会初始化该类 指向的方法所在的类
 */
public class ActiveUse2 {

    // ③ 使用类、接口的静态字段
    @Test
    public void test(){
//        System.out.println(BB.NUM);
//        System.out.println(BB.NUM1);
        System.out.println(interfaceA.NUM);
    }
}

class BB{

    static {
        System.out.println("class AA loaded !");
    }

    // 会
    public static int NUM = 1;

    // 不会
    public static final int NUM1 = 11;

}

interface interfaceA{

    Thread t = new Thread(){
        {
            System.out.println("interfaceA initial...");
        }
    };

    int NUM = 1;

}