package xyz.bugcoder.concurrent.chapter_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-19 17:04
 */
public class ThreadSafePratise {

    private static Logger logger = LoggerFactory.getLogger("ThreadSafePratise");

    public static void main(String[] args) throws InterruptedException {
        TicketWindow tw = new TicketWindow(1000);

        List<Thread> threads = new ArrayList<>();
        List<Integer> sellList = new Vector<>();
        for (int i = 0; i < 2000; i++) {
            Thread t = new Thread(() -> {
                int sell = tw.sell(new Random().nextInt(3));



                sellList.add(sell);
            });
            // 细节，这个threads只会在主线程使用，不存在线程安全问题
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        logger.info("卖出去：" + sellList.stream().mapToInt(I -> I).sum());
        logger.info("剩下的：" + tw.getCount());
    }

}

class TicketWindow{

    // 临界资源
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    // 线程不安全，需要加this锁
    public synchronized int sell(int amount){
        if (count >= amount){
            this.count -= amount;
            return amount;
        }else {
            return 0;
        }
    }

}
