package xyz.bugcoder.pdai.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-03 21:39
 */
public class FileChannels {

    public static void main(String[] args) {
//        test();
//        test2();
        test3();
    }

    // FileChannel 写
    public static void test(){
        try {
            String str = "hello nio";
            FileOutputStream fos = new FileOutputStream("file.txt");
            FileChannel fileChannel = fos.getChannel();

            // 创建一个缓冲区 byteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 往缓冲区写入数据
            byteBuffer.put(str.getBytes());

            // 读写反转
            byteBuffer.flip();

            // 将 byteBuffer 中的数据写入到 channel
            fileChannel.write(byteBuffer);
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // FileChannel 读
    public static void test2(){
        try {
            File file = new File("file.txt");
            FileInputStream fis = new FileInputStream(file);
            FileChannel fileChannel = fis.getChannel();

            // 创建一个缓冲区 byteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
            // 从 channel 中读取数据到 byteBuffer 中
            fileChannel.read(byteBuffer);

            // 将 byteBuffer 中的字节数据 转成 String
            System.out.println(new String(byteBuffer.array()));

            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // FileChannel 文件 copy
    // 只用一个 buffer
    public static void test3(){
        try {
            FileInputStream fis = new FileInputStream("file.txt");
            FileChannel fileChannel1 = fis.getChannel();
            FileOutputStream fos = new FileOutputStream("file2.txt");
            FileChannel fileChannel2 = fos.getChannel();

            // 创建一个缓冲区 byteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 从 channel 中读取数据到 byteBuffer 中
            while (true) {
                // !!!! 记得复位
                byteBuffer.clear();
                int read = fileChannel1.read(byteBuffer);
                if (read == -1) {
                    break;
                }
                byteBuffer.flip();
                fileChannel2.write(byteBuffer);
            }

            fileChannel1.close();
            fileChannel2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
