package xyz.bugcoder.concurrent.chapter_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-19 15:57
 */
public class ThreadSafeTest {

    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;

    public static void main(String[] args) {
        ThreadUnSafe unSafe = new ThreadUnSafe();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                unSafe.method1(LOOP_NUMBER);
            }).start();
        }

//        ThreadSafe safe = new ThreadSafe();
//        for (int i = 0; i < THREAD_NUMBER; i++) {
//            new Thread(() -> {
//                safe.method1(LOOP_NUMBER);
//            }).start();
//        }
    }

}

class ThreadUnSafe {

    // 共享变量
    List<String> list = new ArrayList<>();

    public void method1(int loopNumber){
        for (int i = 0; i < loopNumber; i++) {
            // 临界区
            method2();
            method3();
        }
    }

    private void method2(){
        list.add("1");
    }

    private void method3(){
        list.remove(0);
    }

}

class ThreadSafe {

    public void method1(int loopNumber){
        // 局部变量，多线程情况下会有多个栈帧，换句话说就是各个线程下各有一份，所有不共享使用，也不会出现线程安全去问题
        List<String> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            // 临界区
            method2(list);
            method3(list);
        }
    }

    private void method2(List<String> list){
        list.add("1");
    }

    private void method3(List<String> list){
        list.remove(0);
    }

}