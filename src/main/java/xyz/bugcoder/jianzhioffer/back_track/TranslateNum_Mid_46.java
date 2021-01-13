package xyz.bugcoder.jianzhioffer.back_track;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//
// 示例 1:
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
//
//
// 提示：
//
//
// 0 <= num < 231
//
// 👍 170 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.jianzhioffer.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-13 22:27
 */
public class TranslateNum_Mid_46 {

    private int count = 0;

    /**
     * 思路
     *    回溯，把 n 变成字符数组，每次可以翻译 1 或 2 位
     * 复杂度
     *    时间：O(2^n)
     *    空间：O(N)  ??
     * @param n
     * @return
     */
    public int translateNum(int n) {
        if(n < 10){
            return 1;
        }
        char[] cs = Integer.toString(n).toCharArray();
        int len = cs.length;
        int index = 0;
        backtrack(cs, len, index);
        return count;
    }

    public void backtrack(char[] cs, int len, int index){
        if(index == len){
            count ++;
            return;
        }
        // 翻译 1 位
        backtrack(cs, len, index + 1);
        // 翻译 2 位，第 index 要为 1 或 2，且 index+1 要 <= 5
        if(index + 1 < len && (cs[index] == '1' || cs[index] == '2' && cs[index + 1] <= '5')){
            backtrack(cs, len, index + 2);
        }
    }

    @Test
    public void test(){
        int n = 12250;
        System.out.println(translateNum(n));
    }

}
