package xyz.bugcoder.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-17 17:54
 */
public class FileReader {

    private static Logger logger = LoggerFactory.getLogger("DaemonTest");

    public static void read(String filename){

        try {
            FileInputStream fis = new FileInputStream(filename);
            long start = System.currentTimeMillis();
            logger.info("read {} file....", filename);
            byte[] bytes = new byte[1024];
            int n = -1;
            do {
                n = fis.read(bytes);
            }while (n != -1);
            long end = System.currentTimeMillis();
            logger.info("read file cost {}", end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
