package xyz.bugcoder.jvm.chapter_2;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Launcher;

import java.net.URL;
import java.security.Provider;

/**
 * @Package: xyz.bugcoder.jvm.chapter_2
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-24 20:50
 */

@Slf4j
public class ClassLoaderTest2 {

    public static void main(String[] args) {

        log.info("--------引导类加载器----------");
        // 引导类加载器 加载的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url);
        }

        log.info("--------系统类加载器----------");
        String property = System.getProperty("java.ext.dirs");
        System.out.println(property);

        ClassLoader loader = Provider.class.getClassLoader();
        System.out.println(loader);

    }

}
