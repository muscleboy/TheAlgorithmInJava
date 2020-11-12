package xyz.bugcoder.DesignPattern.structure.visitor;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.visitor
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 16:15
 */

// 基础信息包括；姓名、身份、班级，也可以是⼀个业务⽤户属性类。
public abstract class User {

    public String name;
    public String identity;
    public String clazz;

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    // 为了让后续的⽤ 户具体实现者都能提供出⼀个访问⽅法，共外部使⽤。
    public abstract void accept(Visitor visitor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
