package xyz.bugcoder.concurrent.chapter_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 15:57
 */
public class Downloader {

    public static List<String> download() {
        List<String> list = new ArrayList<>();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://baidu.com").openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null){
                list.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }

}
