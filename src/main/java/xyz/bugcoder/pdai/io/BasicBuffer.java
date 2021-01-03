package xyz.bugcoder.pdai.io;

import java.nio.IntBuffer;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-03 21:07
 */
public class BasicBuffer {

    public static void main(String[] args) {

        // 创建一个大小为 5 的 buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        /*
        limit = position;
        position = 0;
        mark = -1;
         */
        // 读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }

}
