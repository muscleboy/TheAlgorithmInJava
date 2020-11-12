package xyz.bugcoder.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 17:44
 */
public class Pipe {

    static class ReaderThread implements Runnable{

        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("This is reader!");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable{

        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("This is writer!");
            try {
                writer.write("write test~");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    线程ReaderThread开始执行，
//    线程ReaderThread使用管道reader.read()进入”阻塞“，
//    线程WriterThread开始执行，
//    线程WriterThread用writer.write("test")往管道写入字符串，
//    线程WriterThread使用writer.close()结束管道写入，并执行完毕，
//    线程ReaderThread接受到管道输出的字符串并打印，
//    线程ReaderThread执行完毕。
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();

        // 连接才能进行通信
        writer.connect(reader);
        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }

}
