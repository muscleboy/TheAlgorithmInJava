package xyz.bugcoder.pdai.io.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Package: xyz.bugcoder.pdai.io.nio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 21:39
 */

@Slf4j
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel socketChannel;

    private volatile boolean stop;

    /**
     * 初始化多路复用器，绑定监听端口
     */
    public MultiplexerTimeServer(int port) {
        try {
            // 1.打开ServerSocketChannel，来监听客户端的链接
            socketChannel = ServerSocketChannel.open();
            // 2.绑定监听端口、连接为非阻塞模式
            socketChannel.socket().bind(new InetSocketAddress(port), 1024);
            socketChannel.configureBlocking(false);
            // 3.创建
            selector = Selector.open();
            // 监听端口
            // 非阻塞模式
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            log.info("The time server is start in port: " + port);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        try {
            // 无论是否有读写事件的发生，selector 每隔 1 秒都被唤醒一次
            selector.select(1000);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 获取所有就绪状态的 Channel
            Iterator<SelectionKey> it = selectionKeys.iterator();
            SelectionKey key = null;
            // 对就绪状态的 Channel 迭代
            while (it.hasNext()) {
                key = it.next();
                it.remove();
                try {
                    handleInput(key);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                if (key != null) {
                    key.cancel();
                    if (key.channel() != null) {
                        key.channel().close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                // 开辟 1 MB 的缓冲区
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                // 读到了字节，对字节编码
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    log.info("The time server receive: " + body);
                    String curTimes = "query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "bad order";
                    doWrite(sc, curTimes);
                }
                // 未读到字节
                else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                }
                // 链路关闭
                else {

                }
            }
        }
    }

    private void doWrite(SocketChannel sc, String resp) throws IOException {
        if (resp != null && resp.trim().length() > 0) {
            byte[] bytes = resp.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            sc.write(writeBuffer);
        }
    }

}
