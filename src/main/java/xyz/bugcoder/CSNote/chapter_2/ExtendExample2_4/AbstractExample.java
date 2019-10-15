package xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4
 * @Description:
 * @Date: 2019-10-15 18:34
 * @Author: Wyj
 */
public class AbstractExample extends AbstractClassExample {

    @Override
    public void fun1() {
        System.out.println("抽象类的普通方法");
    }

    public AbstractExample() {
        System.out.println("抽象类子类的构造函数");
    }

    public static void main(String[] args) {
        // 抽象类是不能直接实例化
//        AbstractClassExample ac = new AbstractClassExample();
        // 可以new抽象类的子类，向上转型成抽象类
        AbstractClassExample ace = new AbstractExample();
    }

}
