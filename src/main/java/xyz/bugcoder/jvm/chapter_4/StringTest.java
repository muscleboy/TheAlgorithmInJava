package xyz.bugcoder.jvm.chapter_4;

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jvm.chapter_4
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-13 20:22
 */
public class StringTest {


    /**
     * StringBuilder append 执行效率远高于 s = s + "a"(字符拼接)
     * ① 因为拼接会不断 new 新的String和 StringBuilder， 而StringBuilder append始终是一个StringBuilder对象
     * ② 拼接方式；创建了较多的对象，占内存，还容易造成 GC
     *
     * 使用 StringBuilder 传入一个预计的容量，可以减少扩容次数，减少垃圾产生，还能提高性能
     */
    @Test
    public void test1(){

        long start = System.currentTimeMillis();

        // cost: 4005 ms
//        method1(100000);

        // cost: 16 ms
        method2(1000000);

        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }

    public String method1(int times){
        String s = "";
        for (int i = 0; i < times; i++) {
            s = s + "a";
        }

        return s;
    }

    public String method2(int times){

        // 传入一个预计的容量，可以减少扩容次数，减少垃圾产生，还能提高性能
        StringBuilder sb = new StringBuilder(times);
        for (int i = 0; i < times; i++) {
            sb.append("a");
        }

        return sb.toString();
    }

    /**
     * jdk1.9中将 String 改用 byte[] + 编码标记 实现， 节约了一些空间
     * 字符串常量池中不会储存相同内容的字符串
     * jdk1.6以前，字符串常量池放在 永久代
     * jdk1.7以后，字符串常量池放在 堆区
     *
     * 为什么放到堆中？  ① permSize 默认比较小，放太多字符串容易导致 OOM
     *                ② 永久代GC 频率低，容量小，容易 OOM
     */
    @Test
    public void test2(){
        System.out.println();
        System.out.println("1"); // 3984
        System.out.println("2");
        System.out.println("3");

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }

    /**
     * 字符串拼接
     *  常量和常量的拼接结果再常量池中，原理是编译器优化
     *  常量池中不会出现 2 个相同内容的变量
     *  只要有一个是变量，结果就在 堆中； 变量拼接原理：StringBuilder
     *  如果拼接的结果调用 intern()，则主动将常量池中还没有的字符串对象池中，并返回此对象的地址；
     *       如果是常量池中有，就返回对象的地址
     */
    @Test
    public void test3(){

        String s1 = "a" + "b" + "c"; // 等同于 "abc"
        String s2 = "abc"; // 字面量方式，所以是一定是放在常量池中的，将地址返回给 s2

        System.out.println(s1 == s2);  // T
        System.out.println(s1.equals(s2)); // T
    }

    @Test
    public void test4(){

        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        // 编译器优化，等价于 "javaEEhadoop"
        String s4 = "javaEE" + "hadoop";

        // 如果拼接符号的前后出现了变量，就相当于在堆空间中 new String()，内容为字符串拼接的内容
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);  // T
        System.out.println(s3 == s5);  // F
        System.out.println(s3 == s6);  // F
        System.out.println(s3 == s7);  // F
        System.out.println(s5 == s6);  // F
        System.out.println(s5 == s7);  // F
        System.out.println(s6 == s7);  // F

        // intern会看常量池中是否存在 内容为 s6(javaEEhadoop) 的字符串，有直接返回常量池中 javaEEhadoop 的地址
        // 没有，则放入常量池，并返回地址
        String s8 = s6.intern();
        System.out.println(s3 == s8);  // T
    }

    @Test
    public void test5(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";

        /** 查看字节码：
         * String s3 = s1 + s2 的执行细节：
         * ① StringBuilder s = new StringBuilder();
         * ② s.append("a");
         * ③ s.append("b");
         * ④ s.toString()   -->  越等于  new String("ab")
         */

        String s4 = s1 + s2;
        System.out.println(s3 == s4);   // F
    }

    @Test
    public void test6(){
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";

        // s1 s2 final 修饰，此时已经不是遍历，而是常量，会冲常量池中获取，所以是 True
        String s4 = s1 + s2;

        System.out.println(s3 == s4);  // T
    }

    /**
     * new String("ab") 创建了几个对象？  2
     *  一个对象：new 关键字在堆空间中创建的
     *  另一个：字符串常量池中的对象"ab"，字节码指令 ldc
     *
     *
     * new String("a") + new String("b") 呢？
     * 对象 1：new StringBuilder()
     * 对象 2：new String("a")
     * 对象 3：常量池中的"a"
     * 对象 4：new String("b")
     * 对象 5：常量池中的"b"
     *
     * 在深入剖析：StringBuilder.toString()
     *      对象 6：new String("ab")
     *      toString()并没有在常量池中成成字符串 "ab"
     */
    @Test
    public void test7(){
        String s = new String("ab");

        String s1 = new String("a") + new String("b");
    }

    /**
     * 面试题
     *  jdk1.6   vs   jdk1.7以后
     *   false          false
     *   false          true
     */
    @Test
    public void test8(){

        String s1 = new String("g");   // 堆空间的地址
        s1.intern();  //  常量池已经有 "g"
        String s2 = "g";   // 常量池中的地址
        System.out.println(s1 == s2);  // jdk1.7 false

        String s3 = new String("c") + new String("c");
        // 此时常量池中无 "cc", 调用 intern 后常量池中就有了，所有s3 == s4
        s3.intern();
        String s4 = "cc";
        System.out.println(s3 == s4);
    }

    // intern的拓展
    @Test
    public void test9(){

        String s3 = new String("c") + new String("c"); // 堆空间
        String s4 = "cc";   //  常量池， 所以 false
        String s5 = s3.intern();
        System.out.println(s3 == s4);   // F
        System.out.println(s4 == s5);   // T
    }

    // intern的拓展
    @Test
    public void test10(){

        // 会在常量池创建 "cc"
        //  s1 为堆中地址
        //  "cc" 为常量池地址
        //  s2   为常量池地址
//        String s1 = new String("cc");

        // 不会在常量池中创建 "cc"
        String s1 = new String("c") + new String("c");
        String s2 = s1.intern();
        // intern 后，会将"cc"放入常量池
        // s1, s2, "cc"都是常量池的地址

        System.out.println(s2 == "cc");
        System.out.println(s1 == "cc");
    }

}
