package xyz.bugcoder.CartoonAlgorithm.chapter_5;

import java.util.Arrays;

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
     * @param arr : 数组
    * @Returns: int
    **/
    public static int getMissingNum(int[] arr){

        if (arr == null || arr.length == 0)
            return -1;

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }

        return sum;
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-17 08:39
    * @Desc: 拓展：一个无序数组里有若干个正整数，范围是1~100，其中99个整数都出现了偶数次，只有一个出现了奇数次，如何找到出现奇数次的数字？
     * @param arr : 数组
    * @Returns: int
    *           O(n)
    **/
    public static int getMissingNum2(int[] arr){

        if (arr == null || arr.length == 0)
            return -1;

        int result = 0;
        // 依次进行异或运算
        for (int i = 0; i < arr.length; i++) {
            // 相同的数(重复)异或得到0，结果就是 出现奇数次的数字
            result ^= arr[i];
        }

        return result;
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-18 08:25
    * @Desc: 一个无序数组里有若干个正整数，范围是1~100，其中98个整数都出现了偶数次，有2个出现了奇数次，如何找出这两出现奇数次的数？
     * @param arr :
    * @Returns: int
    * O(n)
    **/
    public static int[] getMissingNum3(int[] arr){

        if (arr == null || arr.length == 0)
            return null;

        // 存放2位 两出现奇数次的数
        int[] result = new int[2];
        // 异或运算结果
        int xorResult = 0;
        for (int i : arr) {
            xorResult ^= i;
        }

        // 说明没有出现奇数次的数
        if (xorResult == 0){
            return null;
        }

        int separator = 1;
        while (0 == (xorResult & separator)){
            // 1 <<1 = 2(倒数第二位)
            separator <<= 1;
        }

        for (int i = 0; i < arr.length; i++) {
            // 按倒数第二位为0，1分组
            if (0 == (arr[i] & separator)){
                result[0] ^= arr[i];
            }else {
                result[1] ^= arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,1,6,5,8,9,10};
        int[] arr2 = {3,1,3,2,4,1,4,4,2};
        int[] arr3 = {4,1,2,2,5,1,4,3};
        System.out.println(getMissingNum(arr));
        System.out.println(getMissingNum2(arr2));
        System.out.println(Arrays.toString(getMissingNum3(arr3)));
    }

}
