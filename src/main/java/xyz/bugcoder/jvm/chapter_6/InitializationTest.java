package xyz.bugcoder.jvm.chapter_6;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-25 21:56
 */

/**
 * static final 修饰的字段的显式赋值操作，到底是在哪个阶段赋值？
 * ①：链接-准备
 * ②：初始化<clinit>()
 *
 * 结论：
 *  链接-准备阶段：
 *      1.基本数据类型，使用 static final 修饰, (直接赋值一个常量，而不是调用方法)
 *      2.对应 String 来说，字面量方式赋值，static final 修饰
 *
 * 初始化阶段：
 *  排除上诉情况外
 *
 * 最终结论：
 *      使用 static final 修饰，且 显示赋值不涉及方法或构造器调用的 基本类型或 String 类型的显示赋值， 都是在 链接-准备 阶段进行
 *
 */
public class InitializationTest {

    // ②
    public static int a = 1;

    // ①
    public static final int INT_CONSTANT = 10;

    // ②
    public static final Integer INTEGER_CONSTANT1 = Integer.valueOf(100);

    // ②
    public static Integer INTEGER_CONSTANT2 = Integer.valueOf(1000);

    // ①
    public static final String s = new String("helloworld0");
    // ②
    public static final String s1 = "helloworld1";

}
