package xyz.bugcoder.concurrent.heima_6_nolock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 16:50
 */

@Slf4j
public class ABATest {

    static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {

        log.info("start....");

        // ABA问题，此时的 A 已经被别修改过，虽然又改回来了
        // 但已经不是最初获取到的那个 A，虽然长得一样
        String prev = ref.get();

        change();
        Thread.sleep(1000);

        log.info("chang A -> C {}", ref.compareAndSet(prev, "C"));

    }

    public static void change() throws InterruptedException {
        new Thread(() -> {
            log.info("change A -> B", ref.compareAndSet(ref.get(), "B"));
        }, "t1").start();

        Thread.sleep(500);
        new Thread(() -> {
            log.info("change B -> A", ref.compareAndSet(ref.get(), "A"));
        }, "t2").start();
    }

}
