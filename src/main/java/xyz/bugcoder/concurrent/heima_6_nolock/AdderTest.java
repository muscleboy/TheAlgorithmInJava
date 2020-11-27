package xyz.bugcoder.concurrent.heima_6_nolock;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 17:46
 */

// 累加器
@Slf4j
public class AdderTest {

    public static void main(String[] args) {

        // 专门的累加器性能高，几乎是 AtomicLong 的 10+ 倍
        // 原因：
        //   在竞争时，设置多个累加单元，Thread-0累计 cell[0]， Thread-1累计 cell[1]，
        //   最后结果汇总，这样他们在累加时 操作不同的 cell遍历，减少了 cas 重试次数，从而提高性能
        for (int i = 0; i < 5; i++) {
            demo(
                    () -> new LongAdder(),
                    adder -> adder.increment()
            );
        }

        for (int i = 0; i < 5; i++) {
            demo(
                    () -> new AtomicLong(),
                    adder -> adder.getAndIncrement()
            );
        }

    }

    public static <T> void demo(
            Supplier<T> supplier,
            Consumer<T> consumer){

        T adder = supplier.get();

        long start = System.nanoTime();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ts.add(new Thread(() -> {
                for (int j = 0; j < 400000; j++) {
                    consumer.accept(adder);
                }
            }));
        }

        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.nanoTime();
        log.info("adder: {}, cost: {}", adder, (end - start)/1000_1000);
    }

}
