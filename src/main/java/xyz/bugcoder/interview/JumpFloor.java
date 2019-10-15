package xyz.bugcoder.interview;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description:
 * @Date: 2019-10-15 17:18
 * @Author: Wyj
 */
public class JumpFloor {

    public static int jump(int n){

        if (n <= 0)
            return -1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n > 2)
            return jump(n - 1) + jump(n - 2);

        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(jump(i));
        }
    }

}
