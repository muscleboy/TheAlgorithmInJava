package xyz.bugcoder.jvm.Chapter_3;

/**
 * @Package: xyz.bugcoder.jvm.Chapter_3
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-01 20:21
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    // 占内存
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }

}
