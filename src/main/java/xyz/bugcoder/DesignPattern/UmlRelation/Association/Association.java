package xyz.bugcoder.DesignPattern.UmlRelation.Association;

/**
 * @Package: xyz.bugcoder.DesignPattern.UmlRelation.Association
 * @author: Weiyj
 * @Description: UML类图-关联关系
 * @createTime 2020-10-23 17:39
 */

// 关联关系：类与类之间的关系
// 关联具有导航性：单向或双向
// 关联具有多重性：1:1, 1:n, m:n
public class Association {
}

// 单向
class Person{

    private IDCard idCard;

}

class IDCard{

}

// 双向
//class Person{
//
//    private IDCard idCard;
//
//}
//
//class IDCard{
//
//    private Person person;
//
//}