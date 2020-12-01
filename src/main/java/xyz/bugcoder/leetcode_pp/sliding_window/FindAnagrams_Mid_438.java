package xyz.bugcoder.leetcode_pp.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表
// 👍 416 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.sliding_window
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-01 12:13
 */
public class FindAnagrams_Mid_438 {

    // 思路
    //   滑动窗口模板，当 valid == p.length，记录左指针
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static List<Integer> findAnagrams(String s, String p) {

        if (s == null || s.isEmpty()){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0).intValue() + 1);
        }

        int l = 0;
        int r = 0;
        int valid = 0;

        while(r < s.length()){
            char c = s.charAt(r);
            r ++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0).intValue() + 1);
                if(window.get(c).intValue() == need.get(c).intValue()){
                    valid ++;
                }
            }
            while(r - l >= p.length()){
                if (valid == need.size()){
                    res.add(l);
                }
                char d = s.charAt(l);
                l ++;
                if(need.containsKey(d)){
                    if(window.get(d).intValue() == need.get(d).intValue()){
                        valid --;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }

}
