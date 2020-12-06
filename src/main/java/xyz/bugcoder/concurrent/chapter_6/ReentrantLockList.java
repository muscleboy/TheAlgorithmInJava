package xyz.bugcoder.concurrent.chapter_6;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-06 16:42
 */

// 线程安全的 list
public class ReentrantLockList {

    // 原本线程不安全的 list
    private ArrayList<String> arrayList = new ArrayList<>();

    // 独占锁
    private volatile ReentrantLock lock = new ReentrantLock();

    public void add(String e){
        lock.lock();
        try {
            arrayList.add(e);
        }finally {
            lock.unlock();
        }
    }

    public void remove(String e){
        lock.lock();
        try {
            arrayList.remove(e);
        }finally {
            lock.unlock();
        }
    }

    public String get(int index){
        lock.lock();
        try {
            return arrayList.get(index);
        }finally {
            lock.unlock();
        }
    }

}
