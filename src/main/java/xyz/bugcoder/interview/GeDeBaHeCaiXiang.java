package xyz.bugcoder.interview;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description: 哥德巴赫猜想面试题，6-100的偶数 = 两个素数之和
 * @Date: 2019-10-16 18:57
 * @Author: Wyj
 */
public class GeDeBaHeCaiXiang {

    // 判断素数
    public static boolean isPrime(int n){
        if (n == 2)
            return true;
        else {
            for (int i = 2; i < n; i++) {
                if (n%i == 0)
                    return false;
            }
            return true;
        }
    }

    public static void solution(int a){
        // 6-a
        for (int i = 6; i < a; i++) {
            // 判断偶数
            if (i%2 == 0){
                // 因为1不是素数，所以i-1可以去掉包含1的选项
                for (int j = 2; j < i - 1; j++) {
                    if (isPrime(j) && isPrime(i-j))
                        System.out.println(i + "=" + j + " + " + (i-j));
                }
            }
        }
    }

    public static void main(String[] args) {
        solution(100);
    }

}
