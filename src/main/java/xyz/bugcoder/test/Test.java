package xyz.bugcoder.test;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.test
 * @Description:
 * @Date: 2019-10-09 14:51
 * @Author: Wyj
 */
public class Test {

    public static void test(StringBuffer str){

        String s = String.valueOf(str);
        char[] chs = s.toCharArray();
        for (char c : chs) {
            System.out.print(c + " ");
        }
    }

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("We are happy!");
        Test.test(sb);
    }

}
