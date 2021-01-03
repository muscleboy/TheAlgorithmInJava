package xyz.bugcoder.jvm.chapter_6;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: 自定义类加载器
 * @createTime 2021-01-03 15:34
 */
public class MyClassLoader extends ClassLoader{

    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name){
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            // 字节码路径
            String fileName = path + name + ".class";
            bis = new BufferedInputStream(new FileInputStream(fileName));
            baos = new ByteArrayOutputStream();
            int len;
            byte[] data = new byte[1024];
            while ((len = bis.read(data)) != -1) {
                baos.write(data, 0, len);
            }
            //
            byte[] bytes = baos.toByteArray();
            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bis != null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
