package xyz.bugcoder.CSNote.chapter_2.ReflectExample2_7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.ReflectExample2_7
 * @Description: Java反射
 * @Date: 2019-10-12 17:09
 * @Author: Wyj
 */
public class ReflectExample {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 获取到Class对象
        Class<Example> exampleClass = Example.class;

        // 可以获取到这个类的所有public方法，包括继承过来的
//        Method[] methods = exampleClass.getMethods();
//        for (Method m : methods) {
//            System.out.println(m);
//        }

        // 可以获取到自己定义的方法，不管什么权限
        Method[] ms = exampleClass.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println(m);
        }

        Constructor<Example> constructor = exampleClass.getConstructor();
        Example o = constructor.newInstance();
//        o.setId(10);
//        o.setName("1234");
        System.out.println(o);

        // 通过反射执行方法
//        Method m = exampleClass.getMethod("add", int.class, int.class);
//        System.out.println("通过反射执行add方法，结果是： " + m.invoke(o, 1, 3));
//
//        // 通过反射执行private方法，getDeclaredMethod()才能获取到
//        Method m2 = exampleClass.getDeclaredMethod("privateMethod", String.class, int.class);
//        // 只是获取访问权，并不是修改实际权限
//        m2.setAccessible(true);
//        m2.invoke(o, "Java reflect", 6666);

        // 通过newInstance()创建一个对象，会执行空的构造函数
//        Example example = exampleClass.newInstance();

        // 通过反射获取成员变量，这样只能获取到Public修饰的
//        Field[] fields = exampleClass.getFields();
//        for (Field f : fields) {
//            System.out.println(f);
//        }

        // 通过反射访问private
        Field f = exampleClass.getDeclaredField("MAX_LENGTH");
        f.setAccessible(true);
        System.out.println(f);
//        f.set(Integer.class, 20);
//        System.out.println(f);
    }

}
