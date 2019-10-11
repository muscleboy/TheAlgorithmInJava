package xyz.bugcoder.test;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.test
 * @Description:
 * @Date: 2019-10-10 12:40
 * @Author: Wyj
 */
public class TestAbs extends Test {

    int a[] = {1,23,4,5};
    String s = "asdf";

    @Override
    public void fun() {

        System.out.println(a.length);
        System.out.println(s.length());
        System.out.println("fun");
    }

    public static void main(String[] args) {

        Test a = new TestAbs();
        a.fun();
    }

}
