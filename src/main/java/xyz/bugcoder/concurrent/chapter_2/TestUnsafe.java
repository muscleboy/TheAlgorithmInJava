package xyz.bugcoder.concurrent.chapter_2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_2
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-04 15:14
 */
public class TestUnsafe {

    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            // Unsafe必须通过反射来使用
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args){

        TestUnsafe test = new TestUnsafe();
        boolean b = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(b);
    }

}
