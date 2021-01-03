package xyz.bugcoder.pdai.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-03 20:32
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        ss();
    }

    private static void ss() throws IOException {
        // 1.创建一个线程池
        // 2.如果有客户端连接，就创建一个线程通讯
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            final Socket socket = ss.accept();
            newCachedThreadPool.execute(() -> {
                System.out.println("有一个客户端连接上了: id: " + Thread.currentThread().getId());
                handle(socket);
            });
        }
    }

    public static void handle(Socket socket){
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();

            int read;
            while ((read = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("close...");
            try {
                if (socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
