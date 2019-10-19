package xyz.bugcoder.CSNote.chapter2_1.ExtendExample2_4;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter2_1.ExtendExample2_4
 * @Description:
 * @Date: 2019-10-19 12:35
 * @Author: Wyj
 */
public class MyThread extends Thread {

    int j;

    public MyThread(int j) {
        this.j = j;
    }

    @Override
    public void run() {
        if (j%2 == 0){

            j ++;
            System.out.println(this.getName() + ", j: " + j);
        }else {

            j --;
            System.out.println(this.getName() + ", j: " + j);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(2);
        MyThread t3 = new MyThread(3);
        MyThread t4 = new MyThread(4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
