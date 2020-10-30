package xyz.bugcoder.DesignPattern.create.UmlRelation.Implementation;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.UmlRelation.Implementation
 * @author: Weiyj
 * @Description: UML类图-实现
 * @createTime 2020-10-23 17:32
 */
public interface Implementation {

    void save();
    void delete();

}

// 实现关系：A类实现B类(接口), 是依赖关系的特例
class A implements Implementation{

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
