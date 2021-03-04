package xyz.bugcoder.kuang.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.kuang.observer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-04 10:17
 */
public class ConcreteSubject implements Subject {

    private List<Observer> list = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer o : list) {
            o.update(msg);
        }
    }
}
