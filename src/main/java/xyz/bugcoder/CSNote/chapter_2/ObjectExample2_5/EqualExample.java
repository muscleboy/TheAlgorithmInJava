package xyz.bugcoder.CSNote.chapter_2.ObjectExample2_5;

import java.util.HashSet;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter_2.ObjectExample2_5
 * @Description: equals的实现
 * @Date: 2019-10-12 10:36
 * @Author: Wyj
 */
public class EqualExample {

    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o){

        // 首先判断为空，类是否一致
        if (o == null || getClass() != o.getClass())
            return false;

        EqualExample that = (EqualExample) o;

        if (this == o)
            return true;
        else if (that.x != x)
            return false;
        else if (that.y != y)
            return false;
        else
            return that.z == z;
    }

    public int getCustomHashcode(){

        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;

        return result;
    }

    public static void main(String[] args) {

        EqualExample ee = new EqualExample(1,2,3);
        Example e = new Example(1,2,3);
        EqualExample ee2 = new EqualExample(1,2,3);
        HashSet<EqualExample> set = new HashSet();
        set.add(ee);
        set.add(ee2);
        System.out.println(ee.equals(e));
        System.out.println(ee.equals(ee2));
//        System.out.println(set.size());
//        System.out.println(ee.hashCode());
        System.out.println(Integer.toHexString(ee.getCustomHashcode()));
        System.out.println(Integer.toHexString(ee2.getCustomHashcode()));
    }

}

class Example{

    private int x;
    private int y;
    private int z;

    public Example(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
