package xyz.bugcoder.concurrent.chapter_1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 15:54
 */

@Slf4j
public class GuardedObjectTest {

    public static void main(String[] args) {
        GuardedObject response = new GuardedObject();
        new Thread(() ->{
            log.info("等待结果..." );
            List<String> list = (List<String>) response.get(200);
            log.info("下载完成，结果size为: " + list.size());
        }, "t1").start();

        new Thread(() ->{
            log.info("下载线程启动..." );
            List<String> list = Downloader.download();
            response.complete(list);
        }, "t2").start();
    }

}

// 同步模式之 保护性暂停
// 定义：用一个线程去等待另一个线程
// 要点：
//    1.结果需要从一个线程传递到另一个线程，让他们两关联同一个GuardedObject
//    2.如果有结果不断从一个线程到另一个线程，可以使用消息队列
//    3.JDK 的join，Future的实现就是这个模式
class GuardedObject{

    private Object response;

    // 无限等
//    public Object get(){
//        synchronized (this){
//            while (response == null){
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            return response;
//        }
//    }

    // 带超时时间等待
    public Object get(long timeout){
        synchronized (this){

            // 这段超时的代码和 join 源码的实现一毛一样！！！
            // 起始时间
            long start = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null){
                // 这里是防止虚假唤醒，导致下次再进来的时候，又等了 timeout，会导致等的最大时间超过 timeout
                long waitTime = timeout - passedTime;
                // 超时等待
                if (waitTime <= 0 ){
                    break;
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 等待时间
                passedTime = System.currentTimeMillis() - start;
            }
            return response;
        }
    }

    public void complete(Object o){
        synchronized (this){
            this.response = o;
            this.notifyAll();
        }
    }
}