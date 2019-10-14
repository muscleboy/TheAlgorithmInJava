package xyz.bugcoder.CSNote.chapter_2.ReflectExample2_7;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.ReflectExample2_7
 * @Description:
 * @Date: 2019-10-12 17:09
 * @Author: Wyj
 */
public class ReflectExample {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> c = String.class;
        Object o = c.newInstance();
    }

}
