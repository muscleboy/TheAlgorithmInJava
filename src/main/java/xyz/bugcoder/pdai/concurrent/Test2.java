package xyz.bugcoder.pdai.concurrent;

import java.util.Random;

/**
 * @Package: xyz.bugcoder.pdai.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-12 15:41
 */
public class Test2 {

    // final方法可以被重载
    public final String toString(final String a){
        return a;
    }

    public String toString(){
        return "";
    }

    // 编译期常量
    final int i = 1;
    final static int j = 2;
    final int[] a = {1,23,4};

    // 非编译期常量
    Random r = new Random();
    final int k = r.nextInt();

    public static void main(String[] args) {

    }

}
