package xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4
 * @Description:
 * @Date: 2019-10-15 18:43
 * @Author: Wyj
 */
public interface InterfaceClassExample{

    // 接口内不能有private,protected的字段和方法
//    protected int x = 0;
//    private void fun();
    String name1 = "接口子类";
    // 接口中字段默认public,static, final
    public static final int MAX = 10;
    // 接口中的方法默认为 public,abstract. 但可以修改为default
    public abstract void son1();
    void son2();
//    static void s3(){
//        System.out.println("s3()");
//    }
//    default void s4(){
//        System.out.println("s4()");
//    }
}
