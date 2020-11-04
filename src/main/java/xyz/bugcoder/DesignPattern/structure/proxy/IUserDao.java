package xyz.bugcoder.DesignPattern.structure.proxy;

import xyz.bugcoder.DesignPattern.structure.proxy.agent.Select;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.proxy
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 18:03
 */
// 准备工作2
public interface IUserDao {

    // 定义⼀个Dao层接⼝，并把⾃定义注解添加上
    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
