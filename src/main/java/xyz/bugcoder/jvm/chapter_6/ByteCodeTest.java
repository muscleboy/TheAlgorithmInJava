package xyz.bugcoder.jvm.chapter_6;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 20:27
 */
public class ByteCodeTest {

    public static void main(String[] args) {

        Integer x = 5;
        int y = 5;
        // true, 因为拆箱valueOf
        System.out.println(x == y);

        Integer i1 = 10;
        Integer i2 = 10;
        // true, 在 IntegerCache[-128, 127]内，所以是 true
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        // 超过缓存范围，是 new Integer，所以 false
        System.out.println(i3 == i4);

    }

}
