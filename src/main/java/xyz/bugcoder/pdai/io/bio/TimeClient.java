package xyz.bugcoder.pdai.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Package: xyz.bugcoder.pdai.io.bio
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-12 18:34
 */
@Slf4j
public class TimeClient {

    public static void main(String[] args) {
        int port = 9999;
        Socket s = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            s = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
            out.println("query time order");
            log.info("send order 2 server succeed");
            String resp = in.readLine();
            log.info("now is: " + resp);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
