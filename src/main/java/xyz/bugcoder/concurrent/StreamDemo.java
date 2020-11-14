package xyz.bugcoder.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-14 18:00
 */
public class StreamDemo {

    public static void main(String[] args) {
//        Stream.of(1,2,3,4,5,6,7,8,9)
//                // 并行计算
////                .parallel()
//                .reduce((a, b) ->{
//                    System.out.println(String.format("%s: %s + %s = %s",Thread.currentThread().getName(), a, b, a+b));
//                    return a + b;
//                })
//                .ifPresent(System.out::println);
        System.out.println("计算机核数：" + Runtime.getRuntime().availableProcessors());

        List<Integer> list = new ArrayList<>(1000_1000);
        for (int i = 0; i < 1000_1000; i++) {
            list.add(new Random().nextInt(100));
        }

        long single = System.currentTimeMillis();
        list.stream()
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
        System.out.println("单线程耗时：" + (System.currentTimeMillis() - single) + "ms");

        long multi = System.currentTimeMillis();
        list.stream()
                .parallel()
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
        System.out.println("多线程耗时：" + (System.currentTimeMillis() - multi) + "ms");
    }

}
