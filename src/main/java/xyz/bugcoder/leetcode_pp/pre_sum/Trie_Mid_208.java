package xyz.bugcoder.leetcode_pp.pre_sum;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树
// 👍 479 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: 208
 * @createTime 2020-12-11 09:10
 */
// 208  -- map 实现
public class Trie_Mid_208 {

    class TrieNode{
        Map<Character, TrieNode> next = new HashMap<>();
        boolean isWord;
    }

    TrieNode root;

    public Trie_Mid_208() {
        root = new TrieNode();
    }

    // 思路
    //   insert: 遍历 word，不存在，则创建新的节点；存在，则把该字符所在节点指向当前节点；遍历结束，标记可以形成单词
    //   search: 遍历 word，不存在，则返回 false 找不到；存在，则把该字符所在节点指向当前节点；遍历结束，返回标记
    //   searchWith: 遍历 word，遍历 word，不存在，则返回 false 找不到；存在，则把该字符所在节点指向当前节点；最后返回 true
    // 复杂度
    //   时间：都是O(n)，n 为字符串的长度
    //   空间：O(26*n)
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if (!cur.next.containsKey(c)){
                TrieNode temp = new TrieNode();
                cur.next.put(c, temp);
                cur = temp;
            }else {
                cur = cur.next.get(c);
            }
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie_Mid_208 t = new Trie_Mid_208();
        t.insert("hello");
        t.insert("world");
        System.out.println(t.search("hello"));
        System.out.println(t.startsWith("hel"));
    }

}
