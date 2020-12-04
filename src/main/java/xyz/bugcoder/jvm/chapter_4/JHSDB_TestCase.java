package xyz.bugcoder.jvm.chapter_4;

/**
 * @Package: xyz.bugcoder.jvm.chapter_4
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-04 17:24
 */
public class JHSDB_TestCase {

    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done....");
        }
    }

    private static class ObjectHolder{}

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }

}
