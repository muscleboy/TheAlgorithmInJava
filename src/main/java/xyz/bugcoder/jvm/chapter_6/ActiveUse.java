package xyz.bugcoder.jvm.chapter_6;

import org.junit.Test;

import java.io.*;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-25 22:24
 *
 *
 * 主动使用：意味着调用类的<clinit>(), 即执行的类的初始化阶段
 *
 * 1.创建一个类的实例，如 new、反射、克隆、序列化、反序列化
 * 2.当调用类的静态方法，invokestatic 字节码指令
 * 3.使用类、接口的静态字段，getstatic、putstatic指令
 * 4.使用java.lang.reflect 包中的反射类方法，如 Class.forName("com.ali.dubbo")
 * 5.初始化子类，如果发现父类没有初始化，则先初始化父类
 * 6.一个接口定义了 default 方法，那么直接、间接实现该接口的类的初始化，该接口会在其之前在初始化
 * 7.虚拟机启动，用户需要指定一个要执行的类(main)，虚拟机会先初始化这个类
 * 8.初次调用 MethodHandle 实例，会初始化该类 指向的方法所在的类
 */
public class ActiveUse {

    public static void main(String[] args) {

        AA a = new AA();

    }

    // 序列化
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("aa.dat"));

            oos.writeObject(new AA());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (oos != null) {
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 反序列化
    @Test
    public void test2(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("aa.dat"));

            AA a = (AA) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if (ois != null) {
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // ②调用静态方法
    @Test
    public void test3(){
        AA.staticMethod();
    }

}

class AA implements Serializable {

    static {
        System.out.println("class AA loaded !");
    }

    public static void staticMethod(){
        System.out.println("call staticMethod() ");
    }

}