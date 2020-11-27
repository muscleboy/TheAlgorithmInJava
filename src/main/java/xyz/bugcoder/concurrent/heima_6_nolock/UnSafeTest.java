package xyz.bugcoder.concurrent.heima_6_nolock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Package: xyz.bugcoder.concurrent.heima_6_nolock
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 19:25
 */
public class UnSafeTest {

    // UnSafe基本使用
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // UnSafe 是final 的，首先得通过反射获取到 unsafe 对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        Teacher t = new Teacher();

        // 1.获取到在内存的偏移量，通过修改偏移量的值修改值
        long idOffset = unsafe.objectFieldOffset(t.getClass().getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(t.getClass().getDeclaredField("name"));

        // 2.cas 操作
        unsafe.compareAndSwapInt(t, idOffset, 0, 1);
        unsafe.compareAndSwapObject(t, nameOffset, null, "asdf");

        // 3.测试
        System.out.println(t);

    }

}

class Teacher{

    volatile int id;
    volatile String name;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
