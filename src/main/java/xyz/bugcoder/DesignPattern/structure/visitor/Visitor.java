package xyz.bugcoder.DesignPattern.structure.visitor;

import xyz.bugcoder.DesignPattern.structure.visitor.impl.Student;
import xyz.bugcoder.DesignPattern.structure.visitor.impl.Teacher;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.visitor
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 16:22
 */
// 访问的接⼝⽐较简单，相同的⽅法名称，不同的⼊参⽤户类型。
// 让具体的访问者类，在实现时可以关注每⼀种⽤户类型的具体访问数据对象，例如；升学率和排 名。
public interface Visitor {

    void visit(Student student);

    void visit(Teacher teacher);

}
