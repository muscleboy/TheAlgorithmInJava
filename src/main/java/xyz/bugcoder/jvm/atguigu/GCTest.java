package xyz.bugcoder.jvm.atguigu;

import java.util.ArrayList;

/**
 * @author: weiyj
 * @time 2021-02-06 21:39
 * @desc: todo
 */
public class GCTest {

    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            byte[] arr = new byte[1024 * 100];
            list.add(arr);

            try {
                Thread.sleep(120);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
