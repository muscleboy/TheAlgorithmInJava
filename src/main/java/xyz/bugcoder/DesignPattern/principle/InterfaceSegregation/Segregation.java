package xyz.bugcoder.DesignPattern.principle.InterfaceSegregation;

/**
 * @Package: xyz.bugcoder.DesignPattern.principle.InterfaceSegregation
 * @author: Weiyj
 * @Description: 设计原则-接口隔离原则
 * @createTime 2020-10-18 16:10
 */

// 根据UML类图设计的类、接口
public class Segregation {

    interface interface1{
        void method1();

        void method2();

        void method3();

        void method4();

        void method5();
    }

    class B implements interface1{

        @Override
        public void method1() {
            System.out.println("class B method1");
        }

        @Override
        public void method2() {
            System.out.println("class B method2");
        }

        @Override
        public void method3() {
            System.out.println("class B method3");
        }

        @Override
        public void method4() {
            System.out.println("class B method4");
        }

        @Override
        public void method5() {
            System.out.println("class B method5");
        }
    }

    class D implements interface1{

        @Override
        public void method1() {
            System.out.println("class D method1");
        }

        @Override
        public void method2() {
            System.out.println("class D method2");
        }

        @Override
        public void method3() {
            System.out.println("class D method3");
        }

        @Override
        public void method4() {
            System.out.println("class D method4");
        }

        @Override
        public void method5() {
            System.out.println("class D method5");
        }
    }

    class A{
        public void depen1(interface1 i){
            i.method1();
        }

        public void depen2(interface1 i){
            i.method2();
        }

        public void depen3(interface1 i){
            i.method3();
        }

    }

    class C{
        public void depen1(interface1 i){
            i.method1();
        }

        public void depen4(interface1 i){
            i.method4();
        }

        public void depen5(interface1 i){
            i.method5();
        }

    }

}
