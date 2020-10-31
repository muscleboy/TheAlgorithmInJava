package xyz.bugcoder.DesignPattern.UmlRelation.Dependence;

/**
 * @Package: xyz.bugcoder.DesignPattern.UmlRelation
 * @author: Weiyj
 * @Description: UML类图-依赖
 * @createTime 2020-10-23 17:05
 */

// 依赖关系：
// 1.在类中使用到了对方，如类的成员变量、方法返回值类型、方法的参数、方法中
public class Dependence {

    private A a;
    public void save(B b){};
    public C getC(){
        return new C();
    }

    public void modify(){
        D d = new D();
    }

}

class A{}

class B{}

class C{}

class D{}
