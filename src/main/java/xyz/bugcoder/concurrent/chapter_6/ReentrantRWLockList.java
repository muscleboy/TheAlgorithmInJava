package xyz.bugcoder.concurrent.chapter_6;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-06 16:42
 */

// 基于读写锁的线程安全 list
public class ReentrantRWLockList {

    // 原本线程不安全的 list
    private ArrayList<String> arrayList = new ArrayList<>();

    // 独占锁
    private volatile ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public void add(String e){
        writeLock.lock();
        try {
            arrayList.add(e);
        }finally {
            writeLock.unlock();
        }
    }

    public void remove(String e){
        writeLock.lock();
        try {
            arrayList.remove(e);
        }finally {
            writeLock.unlock();
        }
    }

    public String get(int index){
        readLock.lock();
        try {
            return arrayList.get(index);
        }finally {
            readLock.unlock();
        }
    }

}
