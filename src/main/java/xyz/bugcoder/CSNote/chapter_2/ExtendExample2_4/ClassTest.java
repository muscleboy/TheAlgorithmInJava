package xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.ExtendExample2_4
 * @Description: 继承
 * @Date: 2019-10-12 10:17
 * @Author: Wyj
 */
public class ClassTest {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        a.show(a);
        a.show(b);
        a.show(c);
        a.show(d);
        System.out.println("=======");
        b.show(a);
        b.show(b);
        b.show(c);
        b.show(d);
    }

}

class A{

    public void show(A obj){
        System.out.println("A.show(A)");
    }

    public void show(C obj){
        System.out.println("A.show(C)");
    }

}

class B extends A{

    @Override
    public void show(A obj){
        System.out.println("B.show(A)");
    }
}

class C extends B{

}

class D extends C{}

