package xyz.bugcoder.leetcode_pp.pre_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-15 12:37
 */

// 思路
//   构建前缀树，insert 的时候记录下标index；search 时，利用滑动窗口的思想往下找，外层循环为开始下标
// 复杂度
//   时间：insert: O(n)，n 为单词的长度, search: O(n²)
//   空间：insert: O(n), search: O(n) n 为单词个数
public class MultiSearch_Mid_1893 {

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        int index;
    }

    TrieNode root = new TrieNode();

    // 构建前缀树
    public void insert(String word, int index){
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for (char c  : chars) {
            if (cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new TrieNode();
            }
            cur = cur.next[c - 'a'];
        }
        cur.index = index;
    }

    public int[][] multiSearch(String sentence, String[] words){
        List<Integer>[] list = new List[words.length];
        int[][] res = new int[words.length][];

        for (int i = 0; i < words.length; i++) {
            insert(words[i], i + 1);
            list[i] = new ArrayList<>();
        }

        // 这里双层循环思想是 滑动窗口
        for (int i = 0; i < sentence.length(); i++) {
            TrieNode cur = root;
            for (int j = i; j < sentence.length(); j++) {
                char c = sentence.charAt(j);
                if (cur == null || cur.next[c - 'a'] == null){
                    break;
                }
                // !=0，说明找到了一个符合的下标
                if (cur.next[c - 'a'].index != 0){
                    list[cur.next[c - 'a'].index - 1].add(i);
                }
                // 向下一层找
                cur = cur.next[c - 'a'];
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = new int[list[i].size()];
            for (int j = 0; j < list[i].size(); j++) {
                res[i][j] = list[i].get(j);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MultiSearch_Mid_1893 m = new MultiSearch_Mid_1893();
        String sentence = "mississippi";
        String[] words = {"is","ppi","hi","sis","i","ssippi"};
        System.out.println(Arrays.deepToString(m.multiSearch(sentence, words)));
    }

}
