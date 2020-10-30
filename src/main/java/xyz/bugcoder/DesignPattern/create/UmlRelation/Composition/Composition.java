package xyz.bugcoder.DesignPattern.create.UmlRelation.Composition;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.UmlRelation.Composition
 * @author: Weiyj
 * @Description: UML类图-组合关系
 * @createTime 2020-10-23 17:51
 */
public class Composition {
}

/* 组合
class Computer{

    // mouse, monitor可以和 Computer不可分离，同生共死，则关系升级为组合关系
    private Mouse mouse = new Mouse();
    private Monitor monitor = new Monitor();

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}

class Mouse{}

class Monitor{}
*/

// 组合、聚合
class Person{

    // 组合
    private Heart heart = new Heart();
    // 聚合
    private IDCard idCard;

}

class Heart{}

class IDCard{}