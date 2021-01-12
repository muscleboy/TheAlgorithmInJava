package xyz.bugcoder.pdai.io.nio;

/**
 * @Package: xyz.bugcoder.pdai.io.nio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 22:12
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 9999;
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient").start();
    }

}
