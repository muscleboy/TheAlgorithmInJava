package xyz.bugcoder.concurrent.chapter_1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @Package: xyz.bugcoder.concurrent.chapter_1
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 17:34
 */
public class GuardedSuspendDemo {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new People()).start();
        }

        Thread.sleep(1000);
        for (Integer id : Mailboxes.getIds()) {
            new Thread(new Postman(id, "内容：" + id)).start();
        }
    }

}

// 将 居民 和 送信的人 解耦
class Mailboxes{

    private static Map<Integer, GuardedObj> map = new Hashtable<>();

    private static int id = 0;

    private static synchronized int generateId(){
        return id ++;
    }

    public static GuardedObj createGuardedObj(){
        GuardedObj go = new GuardedObj(generateId());
        map.put(go.getId(), go);
        return go;
    }

    public static GuardedObj getGuardedObj(int id){
        return map.get(id);
    }

    public static Set<Integer> getIds(){
        return map.keySet();
    }

}

@Slf4j
class People implements Runnable{

    public void run() {
        GuardedObj guardedObj = Mailboxes.createGuardedObj();
        log.info("开始收信 id: {}", guardedObj.getId() );
        Object mail = guardedObj.get(2000);
        log.info("收到信：id: {}, 内容{}", guardedObj.getId(), mail);
    }
}

@Slf4j
@Data
class Postman implements Runnable{

    private int id;
    private String mail;

    public Postman(int id, String mail){
        this.id = id;
        this.mail = mail;
    }

    public void run() {
        GuardedObj guardedObj = Mailboxes.getGuardedObj(id);
        log.info("送信：id: {}, 内容：{}", id, mail);
        guardedObj.complete(mail);
    }
}

@Data
class GuardedObj{

    private int id;

    public GuardedObj(int id) {
        this.id = id;
    }

    private Object response;

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