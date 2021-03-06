package xyz.bugcoder.concurrent.chapter_1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: 哲学家就餐问题(死锁演示)
 * @createTime 2020-11-23 17:27
 */
public class PhilosopherEatingQuestion {

    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");

        new Philosopher("苏格拉底1", c1, c2).start();
        new Philosopher("柏拉图2", c2, c3).start();
        new Philosopher("亚里士多德3", c3, c4).start();
        new Philosopher("赫拉克利特4", c4, c5).start();
        new Philosopher("阿基米德5", c5, c1).start();

        // 线程饥饿问题   一个线程由于优先级太低，始终得不到 CPU 调度执行，也不能够结束
//        new Philosopher("阿基米德", c1, c2).start();
    }

}


// 5哲学家，围坐一桌，只有 5 根筷子，每个人都必须拿到左右 2 根筷子, 才能进行吃饭
@Slf4j
class Philosopher extends Thread {

    String name;
    Chopstick left;
    Chopstick right;


    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    // ReentranceLock解决哲学家问题
    @Override
    public void run() {
        // 死锁
//        while (true){
//            // 获得左、右筷子才能吃
//            synchronized (left) {
//                synchronized (right) {
//                    eat();
//                }
//            }
//        }

        // ReentranceLock解决死锁
        while (true){
            // 获得左、右筷子才能吃
            if (left.tryLock()){
                try {
                    if (right.tryLock()){
                        try {
                            eat();
                        }finally {
                            right.unlock();
                        }
                    }
                }finally {
                    // 重点，获取不到右筷子，就让出左筷子
                    left.unlock();
                }
            }
        }
    }

    public void eat() {
        try {
            log.info("eating.....");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

// 筷子
class Chopstick extends ReentrantLock {

    String name;

    public Chopstick(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "筷子{" + name + '}';
    }
}
