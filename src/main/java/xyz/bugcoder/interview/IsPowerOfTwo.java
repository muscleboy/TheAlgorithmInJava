package xyz.bugcoder.interview;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description: 判断一个数是否是2的幂次方
 * @Date: 2019-10-16 19:14
 * @Author: Wyj
 */
public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n){
        if (n < 2)
            return false;
        else {
            do {
                // 如果对2求余 != 直接不满足条件
                // ==0, 当n>1,就继续除以2
                if (n%2 == 0)
                    n /= 2;
                else
                    return false;
            }while (n > 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(64));
    }

}
