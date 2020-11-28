package xyz.bugcoder.concurrent.heima_7;

/**
 * @Package: xyz.bugcoder.concurrent.heima_7
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 16:54
 */
public class Test {

    //  final对应的字节码

    // 0 aload_0
    // 1 invokespecial #1 <java/lang/Object.<init>>
    // 4 aload_0
    // 5 bipush 20
    // 7 putfield #2 <xyz/bugcoder/concurrent/heima_7/Test.a>
    //  ---- 写屏障
    //10 return
    final int a = 20;

    public static void main(String[] args) {

    }

}
