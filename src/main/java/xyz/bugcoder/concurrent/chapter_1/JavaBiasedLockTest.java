package xyz.bugcoder.concurrent.chapter_1;

import org.openjdk.jol.info.ClassLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-20 15:11
 */
public class JavaBiasedLockTest {

    private static Logger logger = LoggerFactory.getLogger("JavaBiasedLockTest");

    public static void main(String[] args) throws InterruptedException {
        Dog d = new Dog();
        logger.info(ClassLayout.parseInstance(d).toPrintable());
//        synchronized (d){
//            logger.info(ClassLayout.parseInstance(d).toPrintable());
//        }

        // 调用 hashcode 后会导致偏向锁撤销
        // 如果在调用 hashcode后还想使用偏向锁，记得去掉JVM参数  -XX: -UsingBiasedLocking
        d.hashCode();
//        Thread.sleep(4090);
        logger.info(ClassLayout.parseInstance(d).toPrintable());
    }

}

class Dog{

}
