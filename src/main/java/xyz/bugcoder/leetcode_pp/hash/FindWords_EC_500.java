package xyz.bugcoder.leetcode_pp.hash;

//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
//
//
//
//
//
//
//
// 示例：
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
//
//
//
//
// 注意：
//
//
// 你可以重复使用键盘上同一字符。
// 你可以假设输入的字符串将只包含字母。
// Related Topics 哈希表
// 👍 114 👎 0

import java.util.*;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 12:05
 */
public class FindWords_EC_500 {

    // 思路
    //   将键盘分层，初始化，然后判断每个子串中各个字符是否在同一层，是就++， 最后这个数 = 这个子串的长度，说明就都是一层的
    // 复杂度
    //   时间：O(N)words[]的字符数
    //   空间：O(1)，常数个键值对
    public static String[] findWords(String[] words) {

        List<String> res = new ArrayList<>();
        // 根据字母按层数分类，放入 map
        String[] levels = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < levels.length; i++) {
            for (int j = 0; j < levels[i].length(); j++) {
                map.put(levels[i].charAt(j), i + 1);
            }
        }

        for (String word : words) {
            int len = word.length();
            int len1 = 0;
            int len2 = 0;
            int len3 = 0;
            for (Character c : word.toUpperCase().toCharArray()) {
                if (map.get(c) == 1){
                    len1 ++;
                }
                if (map.get(c) == 2){
                    len2 ++;
                }
                if (map.get(c) == 3){
                    len3 ++;
                }
                if (len1 == len || len2 == len || len3 == len){
                    res.add(word);
                }
            }
        }

        return res.toArray(new String[]{});
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }

}
