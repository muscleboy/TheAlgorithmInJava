package xyz.bugcoder.DesignPattern.structure.proxy.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.proxy.agent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 18:02
 */

public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);

    private Class<T> mapperInterface;

    // 构造函数来透传被代理类
    public MapperFactoryBean(Class<T> mapperInteface) {
        this.mapperInterface = mapperInteface;
    }


    // 通过继承 FactoryBean ，提供bean对象，也就是⽅法； T getObject()
    @Override
    public T getObject() throws Exception {

        // 在⽅法 getObject() 中提供类的代理以及模拟对sql语句的处理，这⾥包含了⽤户调⽤dao层⽅法 时候的处理逻辑
        InvocationHandler handler = ((proxy, method, args) -> {
            Select select = method.getAnnotation(Select.class);
            logger.info("SQL: {}", select.value().replace("#{uId}", args[0].toString()));
            return args[0] + " To Be Top Javaer";
        });

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    // 提供对象类型
    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    // 单例
    @Override
    public boolean isSingleton() {
        return true;
    }

}
