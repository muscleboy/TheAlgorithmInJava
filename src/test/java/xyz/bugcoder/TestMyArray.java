package xyz.bugcoder;

import org.junit.Test;
import xyz.bugcoder.util.MyArray;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-18 11:31
 */
public class TestMyArray {

    @Test
    public void insert(){

        MyArray ma = new MyArray();
        ma.add(10);
        ma.add(123);
        ma.add(11);
        ma.add(14323);
//        ma.update(3, 10086);
//        ma.show();
//        ma.insert(222, 1);
//        ma.delete(0);
//        System.out.println(ma.search(10));
        System.out.println(ma.search(123));
        ma.show();
//        System.out.println(ma.get(1));
    }

}
