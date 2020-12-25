package xyz.bugcoder.jvm.chapter_6;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-25 22:15
 */

// 交叉加载会导致死锁问题
public class LoadEachOther extends Thread{

    private char flag;

    public LoadEachOther(char flag) {
        this.flag = flag;
        this.setName("Thread+_" + flag);
    }

    public void run(){
        A a = new A();
    }

}

class A{

    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("xyz/bugcoder/jvm/chapter_6/B");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("loaded class A ok !");
    }

}

class B{

    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("xyz/bugcoder/jvm/chapter_6/A");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("loaded class B ok !");
    }

}