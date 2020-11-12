package xyz.bugcoder.DesignPattern.structure.visitor;

import xyz.bugcoder.DesignPattern.structure.visitor.impl.Student;
import xyz.bugcoder.DesignPattern.structure.visitor.impl.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.visitor
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 16:28
 */
// ⾸先在这个类中初始化了基本的数据，学⽣和⽼师的信息。
// 并提供了⼀个展示类，通过传⼊不同的 观察者(校⻓长、家⻓长) ⽽差异化的打印信息。
public class DataView {

    List<User> userList = new ArrayList<>();

    public DataView() {
        userList.add(new Student("谢⻜飞机", "重点班", "⼀年⼀班"));
        userList.add(new Student("windy", "重点班", "⼀年⼀班"));
        userList.add(new Student("⼤⽑", "普通班", "⼆年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));

        userList.add(new Teacher("BK", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("dangdang", "普通教师", "⼆年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }

    // 展示
    public void show(Visitor visitor) {

        for (User user : userList) {
            user.accept(visitor);
        }
    }

}
