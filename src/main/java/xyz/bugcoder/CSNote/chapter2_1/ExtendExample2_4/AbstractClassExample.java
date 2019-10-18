package xyz.bugcoder.CSNote.chapter2_1.ExtendExample2_4;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter2_1.ExtendExample2_4
 * @Description:
 * @Date: 2019-10-15 18:31
 * @Author: Wyj
 */
public abstract class AbstractClassExample {

    private int x;
    private int y;

    public AbstractClassExample() {
        System.out.println("抽象类的构造函数");
    }

    public abstract void fun1();
    public void fun2(){
        System.out.println("抽象类的非抽象方法");
    }
}
