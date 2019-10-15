package xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4
 * @Description:
 * @Date: 2019-10-15 18:51
 * @Author: Wyj
 */
public class InterfaceClass implements InterfaceClassExample {

    @Override
    public void fun1() {

        // 可以看到接口中的字段为static(通过类名.字段访问)，final(不可修改)
//        InterfaceClassExample.id = "23423";
        System.out.println("重写接口中的fun1()");
    }

    @Override
    public void fun2() {
        System.out.println("重写接口中的fun2()");
    }
}
