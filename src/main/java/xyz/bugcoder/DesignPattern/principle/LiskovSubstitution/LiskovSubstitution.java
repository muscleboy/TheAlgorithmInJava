package xyz.bugcoder.DesignPattern.principle.LiskovSubstitution;

/**
 * @Package: xyz.bugcoder.DesignPattern.principle.LiskovSubstitution
 * @author: Weiyj
 * @Description: 里氏替换原则
 * @createTime 2020-10-19 15:43
 */
public class LiskovSubstitution {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("x + y: " + a.func1(1,4));

        B b = new B();
        // 此时调用的func1是B重写后的，而非A中的func1，就会有问题...
        System.out.println("x - y: " + b.func1(1,4));
        System.out.println("x * y: " + b.func2(1,4));
    }

}

class A {
    public int func1(int x, int y){
        return x + y;
    }
}

class B extends A{
    // B继承自 A，并且重写了 func方法
    public int func1(int x, int y){
        return x - y;
    }

    public int func2(int x, int y){
        return x * y;
    }

}