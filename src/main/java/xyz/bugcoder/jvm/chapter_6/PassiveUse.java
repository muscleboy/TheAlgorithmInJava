package xyz.bugcoder.jvm.chapter_6;

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-26 21:49
 *
 * 被动使用，即不会进行类的初始化操作(clinit())
 *
 * 1.当访问一个静态变量，只有真正声明这个字段的类才会被初始化
 *    通过子类引用父类的静态变量，不会导致子类初始化
 * 2.通过数组定义类引用，不会导致初始化
 * 3.引用常量不会触发类或接口的初始化，因为常量在链接阶段就已经被显示赋值了
 * 4.调用 ClassLoader 类的 loadClass() 加载一个类，不是对类的主动引用，所有不会导致类的初始化
 *
 *
 * 未初始化，不意味着未加载
 */
public class PassiveUse {

    // ①
    @Test
    public void test(){
        System.out.println(C.num);
    }

    // ②
    @Test
    public void test2(){
        P[] p = new P[10];
    }

}

class P{

    static {
        System.out.println("parent initialize");
    }

    public static int num = 1;

}

class C extends P{

    static {
        System.out.println("child initialize");
    }

}

interface interA{

}
