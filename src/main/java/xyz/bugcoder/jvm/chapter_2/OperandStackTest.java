package xyz.bugcoder.jvm.chapter_2;

/**
 * @Package: xyz.bugcoder.jvm.chapter_2
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-27 21:57
 */
public class OperandStackTest {

    public void test1(){
        byte i = 13;
        int j = 9;
        int k = i + j;
    }

    public static void main(String[] args) {

    }

    public void test2(){

        // 1
//        int i1 = 10;
//        i1 ++;
//
//        int i2 = 11;
//        ++ i2;

//        // 2
        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++ i5;
//
//        // 3
//        int i7 = 10;
//        i7 = i7++;
//
//        int i8 = 10;
//        i8 = ++i8;

    }

}
