package xyz.bugcoder.concurrent;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 17:59
 */
public class Join {

    static class ThreadA implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我睡完了一秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        // 主线程想等待子线程执行完毕后，获得子线程中的处理完的某个数据，就要用到join方法了。
        thread.join();
        System.out.println("如果不加join方法，我会先被打出来，加了就不一样了");
    }

}
