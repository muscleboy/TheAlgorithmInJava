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
// 校⻓长关注；学⽣的名称和班级，⽼师对这个班级的升学率
public class Principal implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);

    public void visit(Student student) {
        logger.info("学⽣信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

    public void visit(Teacher teacher) {
        logger.info("学⽣信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }

}
