package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 最大公约数
 * @createTime 2020-09-02 08:53
 */
public class GetGreatestCommonDivisor {

    /**
    * @Author: Weiyj
    * @Date: 2020-09-02 08:58
    * @Desc: 求两个的最大公约数-基础版  O(min(a,b))
     * @param a :
     * @param b :
    * @Returns: int
    **/
    private static int getGreatestCommonDivisor(int a, int b){
        int small = a < b ? a : b;
        int big = a > b ? a : b;

        if (big%small == 0)
            return small;

        for (int i = small/2; i > 1; i--) {
            if (small%i == 0 && big%i == 0)
                return i;
        }

        return 1;
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-09-03 07:27
    * @Desc: 最大公约数-辗转相除法(欧几里得法), a,b(a > b)的最大公约数 = a%b 和 b 的最大公约数
     * 近似O(log(max(a,b)))
     * @param a :
     * @param b :
    * @Returns: int
    **/
    public static int gcd(int a, int b){
        int small = a > b ? b : a;
        int big = a > b ? a : b;
        if (big%small == 0)
            return small;

        return gcd(big%small, small);
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-09-03 07:33
    * @Desc: 最大公约数-更相减损术，a,b(a > b)的最大公约数 = a-b 和 b的最大公约数  不稳定，最坏O(max(a,b))
     *  数值比较大时，递归会StackOverflowError
     * @param a :
     * @param b :
    * @Returns: int
    **/
    public static int gcd2(int a, int b){
        if (a == b)
            return a;
        int small = a > b ? b : a;
        int big = a > b ? a : b;
        return gcd2(big - small, small);
    }

    /**
    * @Author: Weiyj
    * @Date: 2020-09-03 08:47
    * @Desc: 最大公约数: 辗转相除法 + 更相减损术  稳定，O(log(max(a,b)))
     * 分情况：1. 偶，偶
     *        2. 偶，奇
     *        3. 奇，偶
     *        4. 奇，奇
     * @param a :
     * @param b :
    * @Returns: int
    **/
    public static int gcd3(int a, int b){
        if (a == b)
            return a;
        if ((a&1) == 0 && (b&1) == 0)
            // 两个偶数的最大公约数 = 2 * gcd(a>>1, b>>1);
            return gcd3(a>>1, b>>1)<<1;
        else if ((a&1) == 0 & (b&1) != 0)
            return gcd3(a>>1, b);
        else if ((a&1) != 0 & (b&1) == 0)
            return gcd3(a, b>>1);
        else{
            int small = a > b ? b : a;
            int big = a > b ? a : b;
            return gcd3(big - small, small);
        }
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(1098043234, 10));
        System.out.println(gcd(1098043234, 10));
//        System.out.println(gcd2(1098043234, 10));
        System.out.println(gcd3(1098043234, 10));
    }

}
