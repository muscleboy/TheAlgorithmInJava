package xyz.bugcoder.jvm.chapter_6;

import java.io.File;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-24 21:57
 */
public class NewTest {

    // 1.创建类实例指令
    public void newInstance(){

        // new #2 <java/lang/Object>
        Object o = new Object();

        // new #3 <java/io/File>
        File f = new File("");
    }

    // 2.创建数组指令
    public void newArray(){

        // newarray 10 (int)
        int[] nums = new int[2];

        // anewarray #2 <java/lang/Object>
        Object[] o = new Object[2];

        // multianewarray #6 <[[I> dim 2
        int[][] ints = new int[4][3];

        // anewarray #7 <[Ljava/lang/String;>
        // []未初始化
        String[][] strings = new String[5][];

    }

    public static void main(String[] args) {

    }

}
