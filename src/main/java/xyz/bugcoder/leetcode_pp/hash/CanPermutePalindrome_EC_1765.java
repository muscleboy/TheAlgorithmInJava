package xyz.bugcoder.leetcode_pp.hash;

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
// 回文串不一定是字典当中的单词。
//
//
//
// 示例1：
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
//
//
//
// Related Topics 哈希表 字符串
// 👍 38 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 11:14
 */
public class CanPermutePalindrome_EC_1765 {

    // 思路
    //   用 map 统计各个字符出现的次数，当 出现次数为 1 的个数，0,1: true，>1: false
    // 复杂度
    //   时间: O(N)
    //   空间: O(N)
    public static boolean canPermutePalindrome(String s) {

        if (s.isEmpty()){
            return false;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 出现次数为 1 的个数，0,1: true，>1: false
        int count = 0;
        for (int i : map.values()) {
            if (i % 2 != 0){
                count ++;
            }
            // 能减少一些判断
            if (count > 1){
                return false;
            }
        }
        return true;
    }

    // 思路
    //   和使用 map 差不多
    // 复杂度
    //   时间: O(N)
    //   空间: O(1)，常数个数组空间
    public static boolean canPermutePalindrome2(String s) {
        char[] chars = s.toCharArray();
        // 各个字符出现的次数
        int[] freq = new int[128];
        for (char c : chars) {
            freq[c] += 1;
        }

        int count = 0;
        for (int i : freq) {
            if (i % 2 != 0){
                count ++;
            }
            // 能减少一些判断
            if (count > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "tactcas";
        System.out.println(canPermutePalindrome(s));
        System.out.println(canPermutePalindrome2(s));
    }

}
