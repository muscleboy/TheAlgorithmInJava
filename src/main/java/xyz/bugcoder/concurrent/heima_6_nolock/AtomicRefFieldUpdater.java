package xyz.bugcoder.concurrent.heima_6_nolock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 17:35
 */

// 字段更新器
@Slf4j
public class AtomicRefFieldUpdater {

    public static void main(String[] args) {

        Student s = new Student();

        // 参数1：哪个类的字段, 字段必须要 volatile 修饰，因为 CAS 操作本身就依赖 volatile 关键字
        // 参数2：字段类型
        // 参数2：字段名
        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(
                Student.class, String.class, "name"
        );

        log.info("success ? {} "  + updater.compareAndSet(s, updater.get(s), "jack ma"));
        log.info("s: " + s);

    }

}

class Student{

    volatile String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}