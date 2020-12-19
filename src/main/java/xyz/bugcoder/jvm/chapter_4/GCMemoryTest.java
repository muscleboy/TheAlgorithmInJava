package xyz.bugcoder.jvm.chapter_4;

/**
 * @Package: xyz.bugcoder.jvm.chapter_4
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-19 22:20
 */

// -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
public class GCMemoryTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        byte[] a1, a2, a3, a4;

        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];
    }

}
