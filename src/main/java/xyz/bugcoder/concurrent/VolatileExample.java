package xyz.bugcoder.concurrent;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-13 15:33
 */
public class VolatileExample {

    int a = 0;
    volatile boolean flag = false;

    public void writer(){
        int a = 1;
        flag = true;
    }

    public void reader(){
        if (flag){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        VolatileExample v = new VolatileExample();
        v.writer();
        v.reader();
    }

}
