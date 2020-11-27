package xyz.bugcoder.concurrent.heima_6_nolock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 17:00
 */
@Slf4j
public class ABASolve {

    // 解决 ABA 问题的关键就是 每做一次修改版本号就要 +1
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {

        log.info("start....");

        String prev = ref.getReference();
        // 版本号
        int stamp = ref.getStamp();
        log.info("main  stamp: {} ", stamp);

        change();
        Thread.sleep(1000);

        log.info("main  stamp: {} ", stamp);
        log.info("stamp: {}, chang A -> C {}", stamp, ref.compareAndSet(prev, "C", stamp, stamp + 1));

    }

    public static void change() throws InterruptedException {
        new Thread(() -> {
            // 版本号
            int stamp = ref.getStamp();
            log.info("stamp: {}, change A -> B {}", stamp, ref.compareAndSet(ref.getReference(), "B", stamp, stamp + 1));
        }, "t1").start();

        Thread.sleep(500);
        new Thread(() -> {
            int stamp = ref.getStamp();
            log.info("stamp: {}, change B -> A {}", stamp, ref.compareAndSet(ref.getReference(), "A", stamp, stamp + 1));
        }, "t2").start();

    }

}
