package xyz.bugcoder.jianzhioffer.amazing;

/**
 * @Package: xyz.bugcoder.jianzhioffer.amazing
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 19:57
 */
public class Add_65 {

    public static int add(int a, int b) {
        while (b != 0){
            int x = a ^ b;
            int y = (a & b) << 1;
            a =  x;
            b = y;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(3,4));
    }

}
