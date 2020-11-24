package xyz.bugcoder.jvm.chapter_2;

/**
 * @Package: xyz.bugcoder.jvm.chapter_2
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 20:50
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        // 获取系统类加载器  sun.misc.Launcher$AppClassLoader@135fbaa4
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 拓展类加载器  sun.misc.Launcher$ExtClassLoader@2503dbd3
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        // 引导类加载器，  null
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        // 对于用户自定义的类来说，使用系统类加载器  sun.misc.Launcher$AppClassLoader@135fbaa4
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // null， 说明String 类是用引导类加载器加载的，Java 的核心类库都是使用这个加载器加载f的
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);

    }

}
