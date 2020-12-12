package xyz.bugcoder.pdai.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: xyz.bugcoder.pdai.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-11 15:59
 */
public class Test1 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        // unmodifiableList不可修改
        List<Object> list = Collections.unmodifiableList(new ArrayList<>());


        while (true){
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }
            ExecutorService pool = Executors.newCachedThreadPool();
            pool.execute(() -> {
                synchronized (vector){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });

            pool.execute(() -> {
                synchronized (vector){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            });

            pool.shutdown();
        }

    }

}
