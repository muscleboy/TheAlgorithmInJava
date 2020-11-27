package xyz.bugcoder.concurrent.heima_6_nolock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 16:20
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {

        AtomicInteger i = new AtomicInteger(5);

//        // ++ i, +1再获取
//        System.out.println(i.incrementAndGet());
//        // i ++，获取再 +1
//        System.out.println(i.getAndIncrement());
//
//        // 2
//        System.out.println(i.get());

//        i.updateAndGet(val -> val * 5);

        System.out.println(i);
    }

    // 这个就是 updateAndGet 的底层实现
    public static int updateAndGet(AtomicInteger i, IntUnaryOperator operator){
        while (true){
            int prev = i.get();
            int next = operator.applyAsInt(prev);
            if (i.compareAndSet(prev, next)){
                return next;
            }
        }
    }

}
