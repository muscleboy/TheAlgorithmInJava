package xyz.bugcoder.jvm.chapter_4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.jvm.chapter_4
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-04 17:55
 */
public class OOMObject {

    static class OOM{
        public byte[] holder = new byte[64 * 1024];
    }

    public static void fillHeap(int num){
        List<OOM> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(50);
                list.add(new OOM());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.gc();
    }

    public static void main(String[] args) {
        fillHeap(1000);
    }

}
