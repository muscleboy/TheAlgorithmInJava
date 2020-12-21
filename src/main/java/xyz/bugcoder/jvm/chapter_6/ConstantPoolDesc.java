package xyz.bugcoder.jvm.chapter_6;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 21:52
 */
public class ConstantPoolDesc {

    public static void main(String[] args) {

        // L：对象类型
        // [：一维数组
        Object[] o = new Object[1];
        // [Ljava.lang.Object;@2503dbd3
        System.out.println(o);

        Long[][] l = new Long[10][];
        System.out.println(l);

        // Z: boolean
        boolean[] b = new boolean[1];
        System.out.println(b);

    }

}
