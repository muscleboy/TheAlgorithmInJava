package xyz.bugcoder.pdai.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Package: xyz.bugcoder.pdai.io.bio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 18:20
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
            while (true) {
                s = ss.accept();
                new Thread(new TimeServerHandler(s)).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (ss != null) {
                log.info("The time server close");
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
