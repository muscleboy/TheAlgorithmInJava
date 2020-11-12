package xyz.bugcoder.DesignPattern.structure.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.structure.visitor.impl.Student;
import xyz.bugcoder.DesignPattern.structure.visitor.impl.Teacher;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.visitor
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 16:23
 */
// 家⻓长关注；⾃⼰家孩⼦的排名，⽼师的班级和教学⽔平
public class Parent implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Parent.class);

    public void visit(Student student) {
        logger.info("学⽣信息 姓名：{} 班级：{} 排名：{}", student.name, student.clazz, student.ranking());
    }

    public void visit(Teacher teacher) {
        logger.info("⽼师信息 姓名：{} 班级：{} 级别：{}", teacher.name, teacher.clazz, teacher.identity);
    }

}
