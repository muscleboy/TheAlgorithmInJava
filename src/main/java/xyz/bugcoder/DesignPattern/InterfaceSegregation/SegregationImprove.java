package xyz.bugcoder.DesignPattern.InterfaceSegregation;

/**
 * @Package: xyz.bugcoder.DesignPattern.InterfaceSegregation
 * @author: Weiyj
 * @Description: 设计原则-接口隔离原则
 * @createTime 2020-10-18 16:10
 */

// 改进，对接口进行拆分，去掉不需要实现的接口
public class SegregationImprove {

    interface interface1{
        void method1();
    }

    interface interface2{
        void method2();
        void method3();
    }

    interface interface3{
        void method4();
        void method5();
    }

    static class B implements interface1, interface2{

        @Override
        public void method1() {
            System.out.println("class B implements method1");
        }

        @Override
        public void method2() {
            System.out.println("class B implements method2");
        }

        @Override
        public void method3() {
            System.out.println("class B implements method3");
        }
    }

    static class D implements interface1, interface3{

        @Override
        public void method1() {
            System.out.println("class D implements method1");
        }

        @Override
        public void method4() {
            System.out.println("class D implements method4");
        }

        @Override
        public void method5() {
            System.out.println("class D implements method5");
        }
    }

    // 类A通过interface1，interface2依赖类B
    static class A{
        public void depend1(interface1 i){
            i.method1();
        }

        public void depend2(interface2 i){
            i.method2();
        }

        public void depend3(interface2 i){
            i.method3();
        }

    }

    // 类C通过interface1，interface3依赖类D
    static class C{
        public void depend1(interface1 i){
            i.method1();
        }

        public void depend4(interface3 i){
            i.method4();
        }

        public void depend5(interface3 i){
            i.method5();
        }

    }

    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }

}
