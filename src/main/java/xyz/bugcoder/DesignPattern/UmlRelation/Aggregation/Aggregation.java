package xyz.bugcoder.DesignPattern.UmlRelation.Aggregation;

/**
 * @Package: xyz.bugcoder.DesignPattern.UmlRelation.Aggregation
 * @author: Weiyj
 * @Description: UML类图-聚合
 * @createTime 2020-10-23 17:47
 */
public class Aggregation {

}

class Computer{

    // mouse, monitor可以和 Computer分离，所以是聚合关系
    private Mouse mouse;
    private Monitor monitor;

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}

class Mouse{}

class Monitor{}