package xyz.bugcoder.kuang.single;

/**
 * @Package: xyz.bugcoder.kuang.single
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-03-03 19:53
 */

// 静态内部类-单例模式
public class Holder {

    private Holder() {
    }

    public static class Inner {
        public static final Holder instance = new Holder();
    }

    public static Holder getInstance() {
        return Inner.instance;
    }

}
