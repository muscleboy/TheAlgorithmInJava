package xyz.bugcoder.leetcode_pp;

import org.junit.Test;

/**
 * @author: weiyj
 * @time 2021-01-24 10:56
 * @desc: todo
 */
public class maximumTime {

    /**
     * 思路
     *    逐位判断是否合法
     * 复杂度
     *    时间：O(N)
     *    空间：O(N)
     * @param time
     * @return
     */
    public String maximumTime(String time) {
        char[] cs = time.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            // "??:11"
            if (i == 0 && cs[i] == '?' && cs[i + 1] == '?') {
                cs[i] = '2';
                cs[i + 1] = '3';
            }
            // "11:??"
            if (i == 3 && cs[i] == '?' && cs[i + 1] == '?') {
                cs[i] = '5';
                cs[i + 1] = '9';
            }
            if (cs[i] == '?' && i == 0) {
                cs[i] = cs[i + 1] > '3' ? '1' : '2';
            }
            else if (cs[i] == '?' && i == 1) {
                cs[i] = cs[i - 1] == '2' ? '3' : '9';
            }
            else if (cs[i] == '?' && i == 3) {
                cs[i] = '5';
            }
            else if (cs[i] == '?' && i == 4) {
                cs[i] = '9';
            }
        }

        return new String(cs);
    }

    @Test
    public void test() {
        String s = "??:3?";
        System.out.println(maximumTime(s));
    }

}
