package xyz.bugcoder.pdai.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-04 18:12
 */
public class FileChannelsFileCopy {

    public static void main(String[] args) {
        copy("/Users/mac/1.jpeg", "/Users/mac/2.jpeg");
    }

    /**
     * 文件复制
     * @param src
     * @param dest
     */
    public static void copy(String src, String dest) {
        try {
            // 输入输出流
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            // 通道
            FileChannel srcChannel = fis.getChannel();
            FileChannel destChannel = fos.getChannel();

            destChannel.transferFrom(srcChannel, 0, srcChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
