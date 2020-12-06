package xyz.bugcoder.jvm.Chapter_3;

/**
 * @Package: xyz.bugcoder.jvm.Chapter_3
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-06 20:26
 */

// -Xms:256M -Xmx:256M -XX:+DoEscapeAnalysis
// 开启逃逸分析后，创建 10000000 个对象耗时 4ms, 并且通过 visualVM 查看内存中并不存在 10000000 个对象，比这个数少很多
// 关闭逃逸分析后，创建 10000000 个对象耗时 267ms,
public class EscapeAnalysisTest {

    static class User{

    }

    public static void alloc(){
        // 未发生逃逸
        User u = new User();
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }

        System.out.println("cost: " + (System.currentTimeMillis() - start) + " ms");

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
