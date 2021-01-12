package xyz.bugcoder.pdai.io.nio;

/**
 * @Package: xyz.bugcoder.pdai.io.nio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 21:37
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 9999;
        MultiplexerTimeServer server = new MultiplexerTimeServer(port);
        new Thread(server, "nio-multiplexer").start();
    }

}
