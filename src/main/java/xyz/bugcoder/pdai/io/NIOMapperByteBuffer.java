package xyz.bugcoder.pdai.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-04 20:33
 */
public class NIOMapperByteBuffer {

    public static void main(String[] args) {

        modify();

    }

    private static void modify() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("file.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            // 读写模式、修改起始位置、映射到内存的大小 5(0~4)
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

            // 0 位置改为 'H'
            // 3 位置改为 'L'
            mappedByteBuffer.put(0, (byte) 'H');
            mappedByteBuffer.put(3, (byte) 'L');
            // 越界
            mappedByteBuffer.put(5, (byte) 'O');

            randomAccessFile.close();
            System.out.println("success !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
