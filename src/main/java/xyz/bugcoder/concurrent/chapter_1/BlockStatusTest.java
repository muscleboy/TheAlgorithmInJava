package xyz.bugcoder.concurrent.chapter_1;

import xyz.bugcoder.concurrent.FileReader;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-17 18:00
 */
public class BlockStatusTest {

    public static void main(String[] args) {
        new Thread(() -> {
            FileReader.read("/Users/mac/Movies/极速燃脂.MOV");
        }, "read-thread").start();

        System.out.println("ok");
    }

}
