package xyz.bugcoder.jianzhioffer.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.jianzhioffer.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-22 11:41
 */
public class FirstUniqChar_EC_50 {

    // 思路
    //   第一次遍历用 map 统计各个字符出现的次数，再次遍历，从 map 中找到出现次数为 1 的，就是结果；未找到直接 return ' '
    // 复杂度
    //   时间：需要遍历两次，O(N)
    //   空间：最多需要常数个容量(26个小写字母)的 map，O(1)
    public static char firstUniqChar(String s) {
        if (s.equals("")){
            return ' ';
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        // 遍历、统计各个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 再次遍历字符数组，出现次数 > 1，继续往下；=1 时，即为 第一个只出现一次的字符
        for (Character c : chars) {
            if (map.get(c) > 1){
                continue;
            }
            return c;
        }

        return ' ';
    }

    // 思路
    //    标记各个字符是否重复出现，重复出现的 取反 最终会为 false，所以只出现一次的会为 true
    //     cccbba
    //  c  !F  T
    //  c  !T  F
    //  c  !T  F
    //  b  !F  T
    //  b  !T  F
    //  a  !F  T
    // 复杂度
    //   时间：需要遍历两次，O(N)
    //   空间：最多需要常数个容量(26个小写字母)的 map，O(1)
    public static char firstUniqChar2(String s) {
        if (s.equals("")){
            return ' ';
        }

        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, !map.containsKey(c));
        }

        for (Character c : chars) {
            if (map.get(c)){
                return c;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String s = "cccbba";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar2(s));
    }

}
