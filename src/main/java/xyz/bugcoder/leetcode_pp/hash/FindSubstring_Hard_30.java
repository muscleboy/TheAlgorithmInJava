package xyz.bugcoder.leetcode_pp.hash;

//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
//
//
//
// 示例 1：
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//
//
// 示例 2：
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
//
// Related Topics 哈希表 双指针 字符串
// 👍 382 👎 0

import java.util.*;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 22:26
 */
public class FindSubstring_Hard_30 {

    // 思路
    //   首先统计每个单词出现的次数，然后每一个子串的去与words 中的单词比较
    //   重点：1.words 中的单词必须连续出现
    //        2.words 中的单词只能出现一次
    //        3.words 中的单词长度相同
    // 复杂度
    //   时间：O(m*n)，m 为 s 的长度，n 为单词数
    //   时间：O(n)，2 个 map 最差需要单词数个键值对
    public static List<Integer> findSubstring(String s, String[] words) {

        if (s.isEmpty() || words.length == 0){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        Map<String, Integer> allWord = new Hashtable<>();
        for (String word : words) {
            allWord.put(word, allWord.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        // words中的单词长度相同
        for (int i = 0; i < s.length() - wordNum * len - 1; i++) {
            // 循环到 words 中存在的单词，就放这里
            Map<String, Integer> map = new HashMap<>();
            // 子串与 words 中单词相等的次数，
            int count = 0;
            while (count < wordNum){
                // 通过偏移量判断每个子串
                String word = s.substring(i + count * len, i + (count + 1) * len);
                // 是 words 中的单词，并统计次数
                if (allWord.containsKey(word)){
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    // 子串重复，出现的次数比 words 中还多, 不满足
                    if (map.get(word) > allWord.get(word)){
                        break;
                    }
                }
                // 不是 words 中的单词，直接下一个
                else {
                    break;
                }
                count ++;
            }
            // 也就是 words 中的单词必须全部要出现
            if (count == wordNum){
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        System.out.println(findSubstring(s, words));
    }

}
