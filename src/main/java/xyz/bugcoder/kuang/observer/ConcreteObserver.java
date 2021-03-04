package xyz.bugcoder.kuang.observer;

/**
 * @Package: xyz.bugcoder.kuang.observer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-04 10:13
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String s) {
        System.out.println(name + ": " + s);
    }
}
