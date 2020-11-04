package xyz.bugcoder.DesignPattern.structure.proxy.agent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import xyz.bugcoder.DesignPattern.structure.proxy.IUserDao;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.proxy.agent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 18:03
 */
public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        // ⽤于定义⼀个bean的基本信 息
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.setScope("singleton");
        // 也包括可以透传给构造函数信息
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(IUserDao.class);
        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, "userDao");
        // 进⾏bean的注册，也就 是注册到 DefaultListableBeanFactory 中
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, beanDefinitionRegistry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

}
