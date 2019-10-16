package xyz.bugcoder;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder
 * @Description:
 * @Date: 2019-10-16 12:42
 * @Author: Wyj
 */
class ThreadMain extends Thread{

    public ThreadMain(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MyThread{
    public static void main(String[] args) {
        ThreadMain t1 = new ThreadMain("t1");
        ThreadMain t2 = new ThreadMain("t2");
        ThreadMain t3 = new ThreadMain("t3");
        t1.run();
        t2.run();
        t3.run();
    }
}
