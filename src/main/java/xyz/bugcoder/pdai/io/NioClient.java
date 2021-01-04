package xyz.bugcoder.pdai.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-04 21:46
 */
public class NioClient {

    public static void main(String[] args) {
        client();
    }

    public static void client(){

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 7000);

            if (!socketChannel.connect(inetSocketAddress)) {
                while (!socketChannel.finishConnect()) {
                    System.out.println("not server, do something");
                }
            }

            String s = "asdf";
            ByteBuffer byteBuffer = ByteBuffer.wrap(s.getBytes());
            socketChannel.write(byteBuffer);

            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
