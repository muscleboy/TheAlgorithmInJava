package xyz.bugcoder.concurrent.chapter_5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_5
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-06 15:14
 */
public class CopyList {

    // 弱一致性
    private static volatile CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        list.add("hello");
        list.add("alibaba");
        list.add("welcome");
        list.add("to");
        list.add("hangzhou");

        Thread t1 = new Thread(() -> {
            list.set(1, "baba");
            list.remove(2);
            list.remove(3);
        }, "t1");

        // 此时获取到的内容还是旧值
//        Iterator<String> it = list.iterator();

        t1.start();
        t1.join();

        Iterator<String> it = list.iterator();
        // 此时从 list 中获取到的内容还是旧的，
        // 所有获取迭代器应在现在结束之后，才会获取到最新的修改
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
