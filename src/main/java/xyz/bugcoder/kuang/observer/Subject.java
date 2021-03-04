package xyz.bugcoder.kuang.observer;

/**
 * @Package: xyz.bugcoder.kuang.observer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-04 10:15
 */
public interface Subject {
    // 发布订阅
    void attach(Observer observer);

    // 删除订阅
    void delete(Observer observer);

    // 通知订阅更新
    void notify(String msg);
}
