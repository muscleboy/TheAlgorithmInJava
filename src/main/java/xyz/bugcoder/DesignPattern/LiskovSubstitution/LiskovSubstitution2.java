package xyz.bugcoder.DesignPattern.LiskovSubstitution;

/**
 * @Package: xyz.bugcoder.DesignPattern.LiskovSubstitution
 * @author: Weiyj
 * @Description: 里氏替换原则
 * @createTime 2020-10-19 15:43
 */
// 里氏替换原则
// 1.所有用到父类的地方，替换成子类后，代码仍能正常运行
// 2.在子类中尽量不要重写父类的方法
// 3.继承增强了两个类之间的耦合度，可以通过组合、聚合、依赖的方式来解决问题
// 4.用到父类的地方换成子类，出现错误，则该子类不应该继承自该父类，或者说 应该重新设计它们之间的关系
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