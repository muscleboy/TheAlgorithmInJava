package xyz.bugcoder.DesignPattern.structure.visitor.impl;

import xyz.bugcoder.DesignPattern.structure.visitor.User;
import xyz.bugcoder.DesignPattern.structure.visitor.Visitor;

import java.math.BigDecimal;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.visitor.impl
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 16:18
 */
public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public Double entranceRatio(){
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
