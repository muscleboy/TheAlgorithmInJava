package xyz.bugcoder.pdai;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.pdai
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-15 17:05
 */
public class Test {

    public static void main(String[] args) {
        List<?>[] list1 = new ArrayList<?>[10];

        // 泛型使用
        Integer[] nums = fun1(1, 2, 3, 4, 5);
        fun2(nums);
    }

    public static <T> T[] fun1(T... args) {
        return args;
    }

    public static <T> void fun2(T param[]) {
        for (T t : param) {
            System.out.println("t: " + t);
        }
    }


    /**
     * 泛型擦除证明
     */
    @org.junit.Test
    public void test(){

        List<String> list1 = new ArrayList<>();
        list1.add("123");

        List<Integer> list2 = new ArrayList<>();
        list2.add(123);

        // true，说明泛型 String 和 Integer 被擦除了
        // 只剩下原始类型 (Object)
        System.out.println(list1.getClass() == list2.getClass());
    }

    /**
     * 泛型擦除证明
     * @throws Exception
     */
    @org.junit.Test
    public void test2() throws Exception {

        List<Integer> list = new ArrayList<>();
        list.add(123);

        // 通过反射添加 其他类型元素
        list.getClass().getMethod("add", Object.class).invoke(list, "asdf");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
