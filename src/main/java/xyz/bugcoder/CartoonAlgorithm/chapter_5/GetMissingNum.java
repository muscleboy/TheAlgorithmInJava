package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 在一个无序的数组里有99个不重复的正整数，范围是1~100，唯独缺少1个1~100的整数。如何找到这个数？
 * @createTime 2020-09-17 08:24
 */
public class GetMissingNum {

    /*
    * @Author: Weiyj
    * @Date: 2020-09-17 08:35
    * @Desc: 先将范围内的数累加，再依次减去数组中的元素，得到的差就是缺少的数字
     * @param n : 数组
    * @Returns: int
    **/
    public static int getMissingNum(int[] n){
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        for (int i = 0; i < n.length; i++) {
            sum -= n[i];
        }

        return sum;
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-17 08:39
    * @Desc: 拓展：一个无序数组里有若干个正整数，范围是1~100，其中99个整数都出现了偶数次，只有一个出现了奇数次，如何找到出现奇数次的数字？
     * @param n : 数组
    * @Returns: int
    **/
//    public static int getMissingNumExt(int[] n){
//
//    }

    public static void main(String[] args) {
        int[] n = {4,2,3,1,6,5,8,9,10};
        System.out.println(getMissingNum(n));
    }

}
