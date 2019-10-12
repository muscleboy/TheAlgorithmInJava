package xyz.bugcoder.CSNote.chapter_2.KeyWord2_6;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.KeyWord2_6
 * @Description:  存在继承的情况下，初始化顺序：静态优先构造，父类优先子类
 * @Date: 2019-10-12 16:22
 * @Author: Wyj
 */
public class StaticExample {

    private int x = 10;
    private static int y = 11;

    // 静态代码块在类的初始化时只运行一次
    static {
        System.out.println("静态代码块");
    }

    public StaticExample() {
        System.out.println("构造函数");
    }

    // 静态内部类：不依赖
    static class StaticInnerClass{}

    // 内部类: 依赖于外部类的实例
    class InnerClass{}

    // 静态方法必须有方法体，也就是说不能为抽象方法
//    public static void a();
//    public abstract static void a();
    public static void show(){

        // 静态方法中，只能访问所属类的静态字段和静态方法,方法中不能有this，super关键字
//        int a = x;
//        int b = y;
//        this.y;
//        super();
        System.out.println("静态方法");
    }

    public static void main(String[] args) {
        StaticExample e = new StaticExample();
        StaticExample e2 = new StaticExample();

        // 内部类: 依赖于外部类的实例
        InnerClass innerClass = e.new InnerClass();
        // 静态内部类：不依赖
        StaticInnerClass staticInnerClass = new StaticInnerClass();

        int a = e.x;
        int b = StaticExample.y;
        System.out.println(a + "  " + b);
        show();
    }

}
