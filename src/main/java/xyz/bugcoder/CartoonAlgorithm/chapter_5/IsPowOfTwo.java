package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 判断一个数是否是2的整数次幂
 * @createTime 2020-09-03 08:57
 */
public class IsPowOfTwo {

    /*
    * @Author: Weiyj
    * @Date: 2020-09-04 07:33
    * @Desc: 判断一个数是否为2的整数次幂， &：11得1，其他0， 时间复杂度：O(1)
     * @param a :
    * @Returns: boolean
    **/
    public static boolean isPowOfTwo(int a){

        return (a & a-1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowOfTwo(321));
    }

}
