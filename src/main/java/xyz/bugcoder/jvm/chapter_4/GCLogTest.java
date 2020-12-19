package xyz.bugcoder.jvm.chapter_4;

import java.util.ArrayList;

/**
 * @Package: xyz.bugcoder.jvm.chapter_4
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-19 22:20
 */

// -Xms60m -Xmx60m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -Xloggc:./gclogs/gc.log
public class GCLogTest {

    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            byte[] arr = new byte[1024 * 1024];
            list.add(arr);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
