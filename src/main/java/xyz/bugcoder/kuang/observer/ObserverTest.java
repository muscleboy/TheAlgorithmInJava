package xyz.bugcoder.kuang.observer;

/**
 * @Package: xyz.bugcoder.kuang.observer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-04 10:20
 */
public class ObserverTest {
    public static void main(String[] args) {
        // 发布订阅
        ConcreteSubject subject = new ConcreteSubject();
        // 观察者(订阅者)
        ConcreteObserver observer1 = new ConcreteObserver("快手");
        ConcreteObserver observer2 = new ConcreteObserver("抖音");

        // 添加订阅
        subject.attach(observer1);
        subject.attach(observer2);

        subject.notify("更新了...");

        subject.delete(observer2);
        subject.notify("删除了一个订阅者");
    }
}
