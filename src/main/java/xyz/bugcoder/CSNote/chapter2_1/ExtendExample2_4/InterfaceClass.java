package xyz.bugcoder.CSNote.chapter2_1.ExtendExample2_4;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter2_1.ExtendExample2_4
 * @Description:
 * @Date: 2019-10-15 18:51
 * @Author: Wyj
 */
public class InterfaceClass implements InterfaceClassExample, InterfaceExtendTest {

    public static void fun3(){
        System.out.println("接口中的fun3()");
    }

    @Override
    public void son1() {

        // 可以看到接口中的字段为static(通过类名.字段访问)，final(不可修改)
//        InterfaceClassExample.id = "23423";
        System.out.println("重写接口中的son1()");
    }

    @Override
    public void son2() {
        System.out.println("重写接口中的son2()");
    }

    @Override
    public void father() {

        System.out.println("接口父类方法");
    }

    public static void main(String[] args) {
        InterfaceClass ic = new InterfaceClass();
        ic.son1();
        ic.son2();
        ic.father();
        System.out.println(InterfaceClassExample.name1);
        System.out.println(InterfaceExtendTest.name);
    }

}
