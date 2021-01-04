package xyz.bugcoder.pdai.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-04 21:31
 */
public class NioServer {

    public static void main(String[] args) {
        server();
    }

    public static void server() {

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            Selector selector = Selector.open();

            serverSocketChannel.socket().bind(new InetSocketAddress(7000));

            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if (selector.select(1000) == 0) {
                    System.out.println("wait 1 s, not server");
                    continue;
                }

                // 已经获取到 关注的事件的集合
                // 通过 selectionKeys 反向获取到 channel
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    // 有新的客户端连接
                    if (selectionKey.isAcceptable()) {
                        // 给该 客户端 生成一个 SocketChannel
                        SocketChannel socketChannel = serverSocketChannel.accept();

                        System.out.println("server suc, socketChannel: " + new Random().nextInt(1000));
                        socketChannel.configureBlocking(false);

                        // 注册到 selector 上
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }

                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        socketChannel.read(buffer);

                        System.out.println("from client: " + new String(buffer.array()));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
