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
public class ThreadSafePratise2 {

    private static Logger logger = LoggerFactory.getLogger("ThreadSafePratise2");

    public static void main(String[] args) throws InterruptedException {

        Account a = new Account(1000);
        Account b = new Account(1000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                a.transfer(b, new Random().nextInt(6));
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                b.transfer(a, new Random().nextInt(6));
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        logger.info("total：" + (a.getMoney() + b.getMoney()));
    }

}

// 转账
class Account{

    // 临界资源
    private int money;

    public int getMoney() {
        return money;
    }

    public Account(int money) {
        this.money = money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 线程不安全，this.money  target.money都发生了读写
    // 所以同步方法是不行的，得同步Account类
    public void transfer(Account target, int money){
        synchronized (Account.class){
            if (this.money >= money){
                this.setMoney(this.money - money);
                target.setMoney(target.money + money);
            }
        }
    }

}
