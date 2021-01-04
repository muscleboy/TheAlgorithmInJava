package xyz.bugcoder.pdai.io;

import java.nio.ByteBuffer;

/**
 * @Package: xyz.bugcoder.pdai.io
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-04 18:22
 */
public class NIOByteBufferPutGet {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(20);

        buffer.putInt(100);
        buffer.putInt(10);
        buffer.putChar('A');
        buffer.putLong(100l);

        buffer.flip();

        // 存的时候是什么类型，取出来就要什么类型去接收
        // 顺序不一致，取出来会不一致、或者出错
//        System.out.println(buffer.getInt());
//        System.out.println(buffer.getInt());
//        System.out.println(buffer.getChar());
//        System.out.println(buffer.getLong());

        // buffer 只读
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        buffer.putChar('b');
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        // ReadOnlyBufferException
//        readOnlyBuffer.putLong(1);
    }

}
