package xyz.bugcoder.concurrent.chapter_1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-01 20:11
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field f = Unsafe.class.getDeclaredFields()[0];
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        while (true) {
            // 申请分配内存
            unsafe.allocateMemory(_1MB);
        }
    }

}
