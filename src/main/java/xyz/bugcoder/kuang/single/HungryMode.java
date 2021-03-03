package xyz.bugcoder.kuang.single;

/**
 * @Package: xyz.bugcoder.kuang.single
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 19:34
 */

// 饿汉式单例模式
// 1.实现简单
// 2.线程安全
public class HungryMode {

    private static final HungryMode instance = new HungryMode();

    private HungryMode() {
    }

    public HungryMode getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        // hashcode 都一样
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(HungryMode.instance);
            }).start();
        }
    }

}
