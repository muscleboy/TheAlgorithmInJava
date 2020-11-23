package xyz.bugcoder.concurrent.heima_4_13_ReentranceLock;

/**
 * @Package: xyz.bugcoder.concurrent.heima_4_13_ReentranceLock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 20:46
 */

// 多线程打印，abc 5次，例如 abcabcabcabcabc
// wait & notify 实现

public class Excercise_3 {

    public static void main(String[] args) {

        WaitNotify wn = new WaitNotify(1, 5);

        new Thread(() -> {
            wn.print("a", 1, 2);
        }).start();
        new Thread(() -> {
            wn.print("b", 2, 3);
        }).start();
        new Thread(() -> {
            wn.print("c", 3, 1);
        }).start();

    }
}

//
class WaitNotify{

    private int flag;

    private int loopTime;

    public WaitNotify(int flag, int loopTime) {
        this.flag = flag;
        this.loopTime = loopTime;
    }

    public void print(String s, int waitFlag, int nextFlag){
        for (int i = 0; i < loopTime; i++) {
            synchronized (this){
                // 条件不满足，等待
                while (flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 满足、打印，下一个、通知其他等待的线程
                System.out.print(s);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
