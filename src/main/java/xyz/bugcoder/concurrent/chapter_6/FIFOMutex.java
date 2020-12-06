package xyz.bugcoder.concurrent.chapter_6;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-06 15:34
 */
public class FIFOMutex {

    private final AtomicBoolean locked = new AtomicBoolean();

    private final Queue<Thread> waiters = new ConcurrentLinkedDeque<>();

    public void lock(String[] args) {
        boolean wasInterrupted = false;
        Thread cur = Thread.currentThread();
        waiters.add(cur);

        while (waiters.peek() != cur || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        waiters.remove();
        if (wasInterrupted)
            cur.interrupt();

    }

    public void unlock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

}
