package xyz.bugcoder.CSNote.chapter_2.StringExample2_2;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.StringExample2_2
 * @Description:
 * String: java9之后，private final byte value[]实现，使用coder来标识编码
 *                  由于使用final来实现的，所以是不可变的(线程安全)
 * StringBuffer: 线程安全，synchronize实现
 * StringBuilder: 线程不安全
 * @Date: 2019-10-14 09:25
 * @Author: Wyj
 */
public class StringTest {

    public static void main(String[] args) {

        // 通过字符串字面量创建的字符串，会自动添加到String Pool中，
        // 当创建了相同的字符串，新的字符串对象指向String Pool中的字符串字面量
        String a = "abc";
        String b = "abc";
        // new方式会在堆中创建一个字符串对象
        String c = new String("abc");
        String d = "ab" + "c";
        // intern()将a引用的字符串放入String Pool，然后返回这个字符串的引用
        String e = a.intern();
        System.out.println(a == b); // true
        System.out.println(a == c); // false
        System.out.println(a == d); // true
        System.out.println(a == e); // true
    }

}
