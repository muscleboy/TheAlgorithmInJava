package xyz.bugcoder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder
 * @Description:
 * @Date: 2019-10-15 19:05
 * @Author: Wyj
 */
public class Test {

    private String s;

    public void test(){
        try {
            System.out.println("asdf");
            return;
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("fi");
        }
    }

    public void test2(){
        try {
            throw new IOException();
        }
        catch (IOException e){
            System.out.println("io");
        }
        catch (Exception e){
            System.out.println("ex");
        }
    }

    public static boolean test3(int n, int a){
        if (n < 2)
            return false;
        else {
            do {
                if (n%2 == 0)
                    n /= 2;
                else
                    return false;
            }while (n > 1);
            return true;
        }
    }

    public static void test4(int n){

        // 6-100
        for (int i = 6; i < n; i++) {
            // 偶数
            if (i%2 == 0){
                // 判断素数
                for (int j = 2; j < i-1; j++) {
                    if (isPrime(j) == 1 && isPrime(i-j) == 1)
                        System.out.println(i + "= " + j + " + " + (i-j));
                }
            }
        }
    }


    public static int isPrime(int n){
        if (n == 2)
            return 1;
        else {
            for (int i = 2; i < n; i++) {
                if (n%i == 0)
                    return 0;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
//        Test t = new Test();
//        t.test();
//        int i = 1;
//        int j = 1;
//        int b = ++ j;
//        int a = i ++ + ++ i + ++ i + i ++;
////        System.out.println(i ++);
////        System.out.println(++ j);
//        System.out.println(a + " " + b);
//        long l = 012;
//        int y = 5;
//        System.out.println(3.0/--y);
//        String s = "1234";
//        System.out.println(s.length());
//        System.out.println(test3(8));
//        System.out.println(isPrime(7));
//        test4(100);
//        int n = 5;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        Map<String, String> map = new HashMap<>();
//        map.put("g", "2");
//        map.put(null, null);
////        map.put(null, 111);
//        System.out.println(map.get("g").hashCode());
        Map<String, Integer> table = new Hashtable<>();
        table.put("g", null);
//        table.put(null, null);
        System.out.println(table);
    }
}
