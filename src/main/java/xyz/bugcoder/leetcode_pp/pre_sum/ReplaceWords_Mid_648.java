package xyz.bugcoder.leetcode_pp.pre_sum;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，
//跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
//
// 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
//
// 你需要输出替换之后的句子。
//
//
//
// 示例 1：
//
// 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by th
//e battery"
//输出："the cat was rat by the bat"
//
//
// 示例 2：
//
// 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
//
//
// 示例 3：
//
// 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa a
//aa aaaaaa bbb baba ababa"
//输出："a a a a a a a a bbb baba a"
//
//
// 示例 4：
//
// 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattle
//d by the battery"
//输出："the cat was rat by the bat"
//
//
// 示例 5：
//
// 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is
// accepted"
//输出："it is ab that this solution is ac"
//
//
//
//
// 提示：
//
//
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 100
// dictionary[i] 仅由小写字母组成。
// 1 <= sentence.length <= 10^6
// sentence 仅由小写字母和空格组成。
// sentence 中单词的总量在范围 [1, 1000] 内。
// sentence 中每个单词的长度在范围 [1, 1000] 内。
// sentence 中单词之间由一个空格隔开。
// sentence 没有前导或尾随空格。
//
// Related Topics 字典树 哈希表
// 👍 97 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-18 12:49
 */
public class ReplaceWords_Mid_648 {

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode root = new TrieNode();

    // 构建前缀树
    // 复杂度
    //   时间：O(m * n)，m为词根列表的长度，n 为每个词根的长度
    //   空间间：O(26 * n)
    public void insert(List<String> words){
        for(String word : words){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.next[c - 'a'] == null){
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            // 直接存整个词根
            cur.word = word;
        }
    }

    // 复杂度
    //   时间：O(n), n 为sentence的长度
    //   空间：O(1)
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();
        // 用词根构建前缀树
        insert(dictionary);

        String[] words = sentence.split(" ");
        for(String word : words){
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                // 已找到词根
                if (cur.next[c - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.next[c - 'a'];
            }
            // 如果找到词根就 append(词根)，不然就 append(sentence 中的单词)
            res.append(cur.word != null ? cur.word : word).append(" ");
        }

        // 去掉尾部的空格
        return res.toString().substring(0, res.length() - 1);
    }

    @Test
    public void test(){
        ReplaceWords_Mid_648 r = new ReplaceWords_Mid_648();
        List<String> roots = Arrays.asList("cat","bat","rat");
        String s = "the cattle was rattled by the battery";
        System.out.println(r.replaceWords(roots, s));
    }

}