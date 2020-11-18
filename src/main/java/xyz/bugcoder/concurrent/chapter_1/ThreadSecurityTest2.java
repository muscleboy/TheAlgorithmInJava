package xyz.bugcoder.concurrent.chapter_1;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-18 23:50
 */
public class ThreadSecurityTest2 {

    public static void main(String[] args) throws InterruptedException {

        Room room = new Room();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public  void run() {
                room.incr();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public  void run() {
                room.decr();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("counter: " + room.getCounter());
    }

}

class Room{

    private int counter = 0;

    // synchronized加在 成员方法 上  ==  synchronized (this)
    // synchronized加在 静态方法 上  ==  synchronized (Room.class)
    public synchronized void incr(){
        counter ++;
    }

    public void decr(){
        synchronized (this){
            counter --;
        }
    }

    // 这里加不加锁结果都一样，为啥？?
    public int getCounter(){
        synchronized (this){
            return counter;
        }
    }

}
