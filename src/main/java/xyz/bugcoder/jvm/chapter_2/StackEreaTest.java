package xyz.bugcoder.jvm.chapter_2;

/**
 * @Package: xyz.bugcoder.jvm.chapter_2
 * @author: Weiyj
 * @Description: 栈区域-对应的字节码
 * @createTime 2020-11-27 21:31
 */
public class StackEreaTest {

    public static void main(String[] args) {

    }

    public void test1(){
        int i = 0;

        // long, double是 64 位的，所以会占用两个 slot
        long j = 0;
        double d = 2.0;
        String s = "1324";
    }

    public void test4(){
        int a = 1;
        {
            int b = 0;
            b = a + 1;
        }
        // 此时 c 占用 b 的 slot
        int c = a + 1;
    }

}
