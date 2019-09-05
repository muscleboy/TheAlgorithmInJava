package xyz.bugcoder.interview;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description:
 * @Date: 2019/9/5 22:17
 * @Author: Wyj
 */
public class Hanoi {

    public static void main(String[] args) {

        hanoiFunction(3, 'A', 'B', 'C');
    }

    /** 
    * @Description:  
    * @Param: [n, from, in, to] 
    * @return: void
    */ 
    public static void hanoiFunction(int n, char from, char in, char to){

        if (n == 1){

            System.out.println("将" + n + "圆环,从" + from + "移动到" + to);
        }else {

            // 将
            hanoiFunction(n - 1, from, to, in);
            System.out.println("将" + n + "圆环,从" + from + "移动到" + to);
            hanoiFunction(n - 1, in, from, to);
        }
    }

}
