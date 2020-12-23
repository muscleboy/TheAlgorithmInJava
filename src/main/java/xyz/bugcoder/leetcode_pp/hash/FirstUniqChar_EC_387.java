package xyz.bugcoder.leetcode_pp.hash;

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.string
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-23 15:01
 */
public class FirstUniqChar_EC_387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] cs = new char[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cs[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test(){
        System.out.println(firstUniqChar("loveleetcode"));
    }

}
