package xyz.bugcoder.pdai.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * @Package: xyz.bugcoder.pdai.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-13 16:31
 */

/*
 * AQS 源代码解读
 *   CAS  自旋   park/unpark
 */

public class AQSSource {

    // 同步状态
    private volatile int state;

    private transient volatile Node head;

    private transient volatile Node tail;

    private static Unsafe unsafe;

    private static long offset;

    static {
        try {
            // 反射
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            offset = unsafe.objectFieldOffset(AQSSource.class.getDeclaredField("offset"));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    // 如果进行修改的时候的值 = expect，就把它改为 update
    public boolean compareAndSetState(int expect, int update){
        return unsafe.compareAndSwapInt(this, offset, expect, update);
    }

    public boolean compareAndSetTail(Node expect, Node update){
        return unsafe.compareAndSwapObject(this, offset, expect, update);
    }

    public boolean compareAndSetHead(Node update){
        return unsafe.compareAndSwapObject(this, offset, null, update);
    }

    public static boolean compareAndSetWaitStatus(Node node, int expect, int update){
        return unsafe.compareAndSwapObject(node, offset, expect, update);
    }

    /** 独占锁
     * 首先尝试去获取锁，tryAcquire成功，直接返回
     * 失败：将当前线程添加到队列中，在队列中检测是否为head 的直接后继，并尝试获取锁，
     * 如果失败，则阻塞当前线程，直到被 "释放锁的线程" 唤醒或者打断，随后再尝试获取锁，如此反复
     */
    public final void acquire(int arg){
        if (!tryAcquire(arg) && acquireQueue(addWaiter(Node.EXCLUSIVE), arg)){

        }
    }

    private boolean tryAcquire(int arg) {
        return false;
    }

    /**
     * 队列为双向链表，从尾部添加一个节点
     */
    public final Node addWaiter(Node mode){
        Node node = new Node(Thread.currentThread(), mode);
        Node prev = tail;

        if (prev != null){
            // 双向链表的尾插
            node.prev = prev;
            // 如果当前节点prev是尾结点，则把node 设置为尾结点
            if (compareAndSetTail(prev, node)){
                prev.next = node;
                return node;
            }
        }

        // 尾结点为空 或则 compareAndSetTail失败， 则入队
        enq(node);
        return node;
    }

    /**
     * 节点入队
     */
    public final Node enq(Node node){
        while (true){
            Node t = tail;
            // 这里初始状态  head = tail = null
            if (t == null) {
                // 头结点为空，就把 new Node 置为头结点
                if (compareAndSetHead(new Node())) {
                    tail = head;
                }
            }
            else {
                // 保证每时每刻 tail.prev 都是 != null 的，
                // 因为是尾插法，所以这里的 tail.prev 也就是 node.prev
                // 如果把 node.prev放到下面的 if 中，会导致一个瞬间 tail.prev = null ????，
                // 导致队列不完整
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }

    /**
     * 队列中的节点通过此方法 获取锁
     */
    public boolean acquireQueue(Node node, int arg){
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;){
                Node p = node.predecessor();
                /**
                 * 如果当前节点(传进来的节点 node)是头结点，就尝试获取锁 tryAcquire
                 * 成功获取锁，则将 当前节点(传进来的节点 node)置为 头结点
                 */
                if (p == head && tryAcquire(arg)) {
                    setHead(node);
                    p.next = null;
                    failed = false;
                    return interrupted;
                }
                /**
                 * 获取锁失败, 根据前驱节点判断是否需要阻塞
                 * 如果阻塞被中断，中断标志interrupted 置为 true
                 * shouldParkAfterFailedAcquire在前驱状态不为 signal 的状态下，都会循环重试获取锁
                 */
                if (shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt()){
                    interrupted = true;
                }
            }
        }finally {
            if (failed) {
                cancelAcquire(node);
            }
        }
    }

    private boolean parkAndCheckInterrupt() {
        return false;
    }

    private void setHead(Node node) {

    }

    // 根据前驱结点的 waitStatus 的状态判断是否阻塞
    private static boolean shouldParkAfterFailedAcquire(Node prev, Node node){
        int ws = prev.waitStatus;
        /**
         * 前驱结点状态为 SIGNAL(-1)，在释放锁后，会唤醒后继节点
         * 所有后继节点(当前节点 node)，现在可以阻塞自己
         */
        if (ws == Node.SIGNAL){
            return true;
        }
        // 此时 ws = 1(CENCELLED)取消状态，向前遍历
        if (ws > 0){
            do {
                node.prev = prev;
                prev = prev.prev;
            }while (prev.waitStatus > 0);
            prev.next = node;
        }else {
            // ws = 未获得所(0) 或 PROPAGATE(-3) 时，设置前驱节点为 SIGNAL
            compareAndSetWaitStatus(prev, ws, Node.SIGNAL);
        }

        return false;
    }

    // todo 未完待续
    private void cancelAcquire(Node node){
        if (node == null) {
            return;
        }

        node.thread = null;
        Node prev = node.prev;
        while (prev.waitStatus > 0){
            node.prev = prev;
            prev = prev.prev;
        }

    }

    static final class Node{

        // 共享模式
        static final Node SHARED = new Node();

        // 独占
        static final Node EXCLUSIVE = null;

        // 当前线程被取消
        static final int CANCELLED = 1;

        // 线程需要被唤醒
        static final int SIGNAL = -1;

        // 在条件队列中
        static final int CONDITION = -2;

        // 释放共享资源时需要通知其他节点
        static final int PROPAGATE = -3;

        volatile Node prev;
        volatile Node next;

        volatile int waitStatus;

        volatile Thread thread;

        Node nextWaiter;

        final boolean isShared(){
            return SHARED == nextWaiter;
        }

        // 获取前驱节点
        final Node predecessor(){
            Node p = prev;
            if (p == null){
                throw new NullPointerException();
            }else {
                return p;
            }
        }

        public Node() {
        }

        // addWaiter
        Node(Thread thread, Node mode){
            this.thread = thread;
            this.nextWaiter = mode;
        }

        // addCondition
        Node(Thread thread, int waitStatus){
            this.thread = thread;
            this.waitStatus = waitStatus;
        }
    }

    class ConditionObject implements Condition{

        private transient Node firstWaiter;

        private transient Node lastWaiter;

        @Override
        public void await() throws InterruptedException {

        }

        @Override
        public void awaitUninterruptibly() {

        }

        @Override
        public long awaitNanos(long nanosTimeout) throws InterruptedException {
            return 0;
        }

        @Override
        public boolean await(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public boolean awaitUntil(Date deadline) throws InterruptedException {
            return false;
        }

        @Override
        public void signal() {

        }

        @Override
        public void signalAll() {

        }
    }

}
