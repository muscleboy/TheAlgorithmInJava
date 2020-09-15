package xyz.bugcoder.CartoonAlgorithm.chapter_5;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 大整数(超范围)相加
 * @createTime 2020-09-14 08:06
 */
public class BigIntAdd {

    /*
    * @Author: Weiyj
    * @Date: 2020-09-15 08:24
    * @Desc: 大整数(超范围)相加
     * @param a :
     * @param b :
    * @Returns: java.lang.String
    **/
    public static String bigIntAdd(String a, String b){
        // 结果数组，+1：进位
        int[] result = new int[a.length() > b.length() ? a.length() + 1 : b.length() + 1];

        // 1.将数组倒序，从左到右计算更接近人的习惯
        int[] arrA = new int[result.length];
        for (int i = 0; i < a.length(); i++) {
            // 倒序
            arrA[i] = a.charAt(a.length() - 1 - i) - '0';
        }
        int[] arrB = new int[result.length];
        for (int i = 0; i < b.length(); i++) {
            arrB[i] = b.charAt(b.length() - 1 - i) - '0';
        }

        // 2.逐位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrA[i];
            temp += arrB[i];
            // > 9 进位，但是是逆序的，所以是-10
            if (temp > 9){
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }

        // 3.结果再逆回去
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0 ; i--) {
            // 去掉前面的 0
            if (!findFirst){
                if (result[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "426709752318";
        String b =  "95481253129";
        System.out.println(bigIntAdd(a, b));
    }

}
