package xyz.bugcoder.pdai.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @Package: xyz.bugcoder.pdai.io.bio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 18:26
 */

@Slf4j
public class TimeServerHandler implements Runnable {

    private Socket s;

    public TimeServerHandler(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter out = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            out = new PrintWriter(this.s.getOutputStream(), true);
            String curTime = null;
            String body = null;
            while (true) {
                body = bufferedReader.readLine();
                if (body == null) {
                    break;
                }
                log.info("The time server receive: " + body);
                curTime = "query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "bad query";
                out.println(curTime);
            }
        } catch (IOException e) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
            if (this.s != null) {
                try {
                    this.s.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
