package xyz.bugcoder.test;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.test
 * @Description:
 * @Date: 2019-10-09 14:51
 * @Author: Wyj
 */
public abstract class Test {

    public abstract void fun();

    private static class Dog{
        String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
         String getObjectAddress(){
            return super.toString();
        }

    }

    public static void main(String[] args) {

        Dog d = new Test.Dog("1");
        double a = 11 * 15;
        if (d instanceof Dog)
            System.out.println("a");
    }


    // String
    @org.junit.Test
    public void test(){

        String s1 = new String("asdf");
        String s2 = new String("asdf");
        System.out.println(s1 == s2);  // false
        // intern()将a1引用的字符串添加到String Pool，并返回这个字符串的引用
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4); // true

        short s = 1;
        byte b = 1;
        System.out.println(s);
    }

}
