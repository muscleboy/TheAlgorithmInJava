package xyz.bugcoder.pdai.io.aio;

import lombok.extern.slf4j.Slf4j;
import xyz.bugcoder.pdai.io.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Package: xyz.bugcoder.pdai.io.aio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 21:17
 */

@Slf4j
public class TimeServer {

    public static void main(String[] args) {
        int port = 9999;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
            log.info("The time server is start in port: " + port);
            Socket s = null;
            TimeServerHandlerThreadPool singleExcutor = new TimeServerHandlerThreadPool(50, 10000);
            while (true) {
                s = ss.accept();
                singleExcutor.execute(new TimeServerHandler(s));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
