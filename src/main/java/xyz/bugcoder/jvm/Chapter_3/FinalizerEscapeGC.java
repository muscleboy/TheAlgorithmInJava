package xyz.bugcoder.jvm.Chapter_3;

/**
 * @Package: xyz.bugcoder.jvm.Chapter_3
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-01 20:45
 */
public class FinalizerEscapeGC {

    public static FinalizerEscapeGC hook = null;

    public void isAlive(){
        System.out.println("yes, i am alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method saved me!");
        // 自救
        FinalizerEscapeGC.hook = this;
    }

    public static void main(String[] args) throws InterruptedException {
        hook = new FinalizerEscapeGC();

        // 第一次会自救成功
        hook = null;
        // gc的时候会调用该对象的 finalize()
        System.gc();
        Thread.sleep(500);
        if (hook != null){
            hook.isAlive();
        }else {
            System.out.println("no, i am dead1...");
        }

        hook = null;
        System.gc();
        Thread.sleep(500);
        if (hook != null){
            hook.isAlive();
        }else {
            System.out.println("no, i am dead2...");
        }

    }

}
