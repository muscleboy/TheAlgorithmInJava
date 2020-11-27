package xyz.bugcoder.concurrent.heima_6_nolock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 19:38
 */
public class MyAtomicInteger implements Account{

    private volatile int value;

    private static final Unsafe unsafe;

    private static long valueOffset;

    static {
        unsafe = getUnSafe();
        try {
            valueOffset = unsafe.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    // 获取到 UNSafe 对象
    public static Unsafe getUnSafe(){

        Unsafe unsafe = null;
        try {
            // UnSafe 是final 的，首先得通过反射获取到 unsafe 对象
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return unsafe;
    }

    @Override
    public Integer getBalance() {
        return value;
    }

    @Override
    public void withdraw(Integer amount) {
        // cas操作
        while (true){
            int prev = this.value;
            int next = prev - amount;
            if (unsafe.compareAndSwapInt(this, valueOffset, prev, next)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Account.demo(new MyAtomicInteger(10000));
    }

}
