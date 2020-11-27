package xyz.bugcoder.concurrent.heima_6_nolock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 15:55
 */
public class NotSafeTest {

    public static void main(String[] args) {
        Account.demo(new AccountUnSafe(10000));
        Account.demo(new AccountCas(10000));
    }

}


class AccountUnSafe implements Account{

    private Integer balance;

    public AccountUnSafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void withdraw(Integer amount) {
        // 非线程安全
//        balance -= amount;

        // 基于锁的线程安全
        synchronized (this){
            balance -= amount;
        }
    }
}

// 无锁之 cas
class AccountCas implements Account{

    private AtomicInteger balance;

    public AccountCas(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        // 使用起来不方便
//        while (true){
//            // 余额最新值
//            int prev = balance.get();
//
//            // 取款后，也就是要修改为 next
//            int next = prev - amount;
//
//            if (balance.compareAndSet(prev, next)){
//                break;
//            }
//        }

        // 效果一样
        balance.getAndAdd(-1 * amount);
    }
}

interface Account {

    Integer getBalance();

    void  withdraw(Integer amount);

    static void demo(Account account){
        List<Thread> ts = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        ts.forEach(Thread::start);
        ts.forEach( t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        System.out.println(account.getBalance() + " , cost: " + (end - start) + " ms");
    }

}
