package xyz.bugcoder.pdai.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-04 20:52
 */
public class ScatterAndGather {

    public static void main(String[] args) {

        connect();

    }

    /**
     * Scatter: ByteBuffer[] 写入到 buffer
     * Gather: 从 ByteBuffer[] 读取
     */
    private static void connect(){
        try {
            System.out.println("start...");
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

            // 绑定端口到 socket，并启动
            serverSocketChannel.socket().bind(inetSocketAddress);

            // 创建 buffer 数组
            ByteBuffer[] buffers = new ByteBuffer[2];
            buffers[0] = ByteBuffer.allocate(5);
            buffers[1] = ByteBuffer.allocate(3);

            // 等待客户端连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            int length = 8;
            while (true) {
                int read = 0;
                while (read < length) {
                    long r = socketChannel.read(buffers);
                    read += r;
                    System.out.println("read: " + read);

                    Arrays.stream(buffers).map(buffer -> "pos: " + buffer.position() + ", limit: " + buffer.limit()).forEach(System.out::println);
                }

                // 将所有的 buffers 反转
                Arrays.asList(buffers).forEach(Buffer::flip);

                long w = 0;
                while (w < length) {
                    long l = socketChannel.write(buffers);
                    w += l;
                }

                // 将所有的 buffers 复位
                Arrays.asList(buffers).forEach(Buffer::clear);

                System.out.println("read: " + read + ", write: " + w + ", length: " + length);
                Arrays.asList(buffers).forEach(byteBuffer -> System.out.println(new String(byteBuffer.array())));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("finished...");
        }
    }


}
