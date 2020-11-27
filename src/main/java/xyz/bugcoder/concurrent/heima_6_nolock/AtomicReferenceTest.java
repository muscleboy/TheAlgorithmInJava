package xyz.bugcoder.concurrent.heima_6_nolock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 16:31
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        DecimalAccount.demo(new DecimalAccountCas(new BigDecimal(10000)));
    }

}

class DecimalAccountCas implements DecimalAccount{

    // 引用原子类
    private AtomicReference<BigDecimal> balance;

    public DecimalAccountCas(BigDecimal balance) {
        this.balance = new AtomicReference<>(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {

        while (true){
            BigDecimal prev = balance.get();
            BigDecimal next = prev.subtract(amount);
            if (balance.compareAndSet(prev, next)){
                break;
            }
        }

    }
}

interface DecimalAccount{

    BigDecimal getBalance();

    void withdraw(BigDecimal bigDecimal);

    // CAS 使用场景：线程数不超过  CPU 核心数，才能比较好的发挥 cas的威力
    static void demo(DecimalAccount account){
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(BigDecimal.TEN);
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

        System.out.println("balance: " + account.getBalance());
    }

}