package xyz.bugcoder.DesignPattern.structure.visitor.impl;

import xyz.bugcoder.DesignPattern.structure.visitor.User;
import xyz.bugcoder.DesignPattern.structure.visitor.Visitor;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.visitor.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 16:18
 */
public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public int ranking(){
        return (int) (Math.random() * 100);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
