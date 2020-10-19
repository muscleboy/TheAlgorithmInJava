package xyz.bugcoder.DesignPattern.LiskovSubstitution;

/**
 * @Package: xyz.bugcoder.DesignPattern.LiskovSubstitution
 * @author: Weiyj
 * @Description: 里氏替换原则
 * @createTime 2020-10-19 15:43
 */
public class LiskovSubstitution2 {

    public static void main(String[] args) {
        A2 a = new A2();
        System.out.println("x + y: " + a.func1(1,4));

        System.out.println("--------------");
        B2 b = new B2();
        // 此时调用的func1是B重写后的，而非A中的func1，就会出现问题...
        System.out.println("x - y: " + b.func1(1,4));
        System.out.println("x * y: " + b.func2(1,4));
        System.out.println("x + y: " + b.func3(1,4));
    }

}

// 改进：A，B都继承自一个更加基础的类Base
// 这样A，B之前的耦合度就降低了

class Base{

}

class A2 extends Base{

    public int func1(int x, int y){
        return x + y;
    }

}

class B2 extends Base{

    // 如果还是需要使用到A2中的func1，可以使用组合的方式实现
    private A2 a = new A2();

    public int func1(int x, int y){
        return x - y;
    }

    public int func2(int x, int y){
        return x * y;
    }

    public int func3(int x, int y){
        return a.func1(x, y);
    }

}