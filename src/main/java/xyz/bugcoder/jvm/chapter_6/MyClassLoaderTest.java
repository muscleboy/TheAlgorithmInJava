package xyz.bugcoder.jvm.chapter_6;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-03 15:45
 */
public class MyClassLoaderTest {

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader("/Users/mac/");

        try {
            Class clazz = loader.loadClass("MyClassLoader");
            System.out.println("加载此类的类加载器：" + clazz.getClassLoader().getClass().getName()); // MyClassLoader
            System.out.println("加载此类的类加载器的父类加载器：" + clazz.getClassLoader().getParent().getClass().getName()); // Launcher$AppClassLoader
            System.out.println("加载此类的类加载器的父类加载器的父类加载器：" + clazz.getClassLoader().getParent().getParent().getClass().getName()); // Launcher$ExtClassLoader
            System.out.println("加载此类的类加载器的父类加载器的父类加载器的父类加载器：" + clazz.getClassLoader().getParent().getParent().getParent().getClass().getName()); // null
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
