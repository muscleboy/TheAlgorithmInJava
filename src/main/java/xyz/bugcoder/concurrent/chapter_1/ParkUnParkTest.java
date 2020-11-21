package xyz.bugcoder.concurrent.chapter_1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 19:34
 */
@Slf4j
public class ParkUnParkTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                log.info("runing.....");
                Thread.sleep(1000);
                log.info("park....");
                // 在哪个线程中使用，就暂停哪个线程, 状态为：Wait
                LockSupport.park();
                log.info("resume.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();

        Thread.sleep(2000);
        log.info("unpark....");
        // 把 传入的线程 恢复运行，从暂停位置往后运行
        LockSupport.unpark(t1);
    }
}

// park 和 wait & notify的区别
// park可以直接使用，但 wait & notify 需要和Object Monitor 使用
// park 可以精确的唤醒某个线程，而 notify 的唤醒的随机的
// 可以先 unpark 在 park之前，这个操作会使得那个线程运行的时候不会 park(暂停)， 而wait & notify 不能先 notify


// park 底层原理 counter(干粮)，cond(帐篷)，mutex
// 调用 park：是看干粮是否充足，是的话：不需要停，可以继续；不是：需要等待休息

// 调用 unpark(补充干粮)：处于休息状态：继续运行； 运行中：下次调用 park 的时候，只是需要消耗干粮，不需要停留休息
// 需要注意的是：背包有线，多次调用 unpark 并不会补充多份干粮，最多一份
