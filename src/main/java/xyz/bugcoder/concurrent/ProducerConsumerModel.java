package xyz.bugcoder.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Package: xyz.bugcoder.concurrent
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-14 16:59
 */
public class ProducerConsumerModel {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    class Producer extends Thread{
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            for(int i = 0; i < 10; i ++){
                try {
                    queue.put(1);
                    System.out.println("从队列放入一个元素，队列剩余 "+queue.size()+"个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            for(int i = 0; i < 10; i ++){
                try {
                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余 "+queue.size()+"个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerModel pcm = new ProducerConsumerModel();
        Producer producer = pcm.new Producer();
        Consumer consumer = pcm.new Consumer();

        producer.start();
        consumer.start();
    }

}
