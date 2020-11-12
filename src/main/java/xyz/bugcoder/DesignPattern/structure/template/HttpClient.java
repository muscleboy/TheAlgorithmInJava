package xyz.bugcoder.DesignPattern.structure.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.template
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 15:04
 */
public class HttpClient {

    public static String get(String httpUrl){

        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;

        try {
            // 创建远程url连接对象
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();

            // 请求成功
            if (connection.getResponseCode() == 200){
                is = connection.getInputStream();
                // 封装输入流，并制定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放返回的数据
                StringBuilder sb = new StringBuilder();
                String temp;
                while ((temp = br.readLine()) != null){
                    sb.append(temp);
                    sb.append("\r\n");
                }
                result = sb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭资源
        finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            assert connection != null;
            connection.disconnect();
        }

        return result;
    }

}
