package xyz.bugcoder.leetcode_pp.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-16 22:27
 */
public class WordPattern_EC_290 {

    public static boolean wordPattern(String pattern, String s) {
        Map<Object, Integer> map = new HashMap();
        String[] strs = s.split(" ");
        // 1.首先长度得相同
        if (pattern.length() != strs.length){
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            // 2.对应位置的下标相同，则会符合 pattern
            // 如果 map 中没有对应的 key，会返回 value = null；如果存在 key，则返回 oldValue
            // 细节：Objects.equals
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(strs[i], i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String p = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(p, s));
    }

}
