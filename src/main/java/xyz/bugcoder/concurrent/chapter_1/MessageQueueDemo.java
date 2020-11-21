package xyz.bugcoder.concurrent.chapter_1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 19:08
 */
public class MessageQueueDemo {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        for (int i = 0; i < 4; i++) {
            int id = i;
            new Thread(() -> {
                Message message = new Message(id, "消息" + id);
                queue.put(message);
            }, "生产者" + id).start();
        }

        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = queue.take();
            }
        }, "消费者").start();
    }

}


@Slf4j
// 消息队列类，Java 线程间通信
class MessageQueue{

    // 消息集合
    private final LinkedList<Message> queue = new LinkedList<>();

    // 消息队列容量
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    // 获取消息消费
    public Message take(){

        synchronized (queue){
            while (queue.isEmpty()){
                try {
                    log.info("队列为空，等待生产者生产~~~");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 从队列头获取消息
            Message message = queue.removeFirst();
            log.info("消费消息：{}", message);
            queue.notifyAll();
            return message;
        }
    }

    // 将生产的消息放入队列
    public void put(Message message){
        synchronized (queue){
            while (queue.size() == capacity){
                try {
                    log.info("队列已满，等待消费者消费~~~");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 消息入队，队尾
            queue.addLast(message);
            log.info("生产消息~~~, {}", message);
            queue.notifyAll();
        }
    }

}

@Data
class Message{

    private int id;
    private String value;

    public Message(int id, String value) {
        this.id = id;
        this.value = value;
    }

}
