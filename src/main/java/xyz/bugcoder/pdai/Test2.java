package xyz.bugcoder.pdai;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author: weiyj
 * @time 2021-02-23 21:00
 * @desc: todo
 */

public class Test2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c = Class.forName("xyz.bugcoder.pdai.User2");

        Field f = c.getDeclaredField("name");
        Annotation[] annotations = f.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}

class User2 {

    @Test1(column = "id", type = "int", len = 10)
    private int id;

    @Test1(column = "age", type = "int", len = 10)
    private int age;

    @Test1(column = "name", type = "varchar", len = 10)
    private String name;

}

// 自定义注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test1 {

    String column() default "";
    String type() default "";
    int len() default 0;

}
