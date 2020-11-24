package xyz.bugcoder.jvm.chapter_2;

/**
 * @Package: xyz.bugcoder.jvm.chapter_2
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 20:19
 */
public class ClassInitTest {

    private static int x = 1;

    static {
        int y = 10;


        z = 20;
        // 前向引用错误
//        System.out.println(z);
    }

    static int z = 10;

    public ClassInitTest() {
        x = 20;
        z = 20;
    }

    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(z);
    }

}
