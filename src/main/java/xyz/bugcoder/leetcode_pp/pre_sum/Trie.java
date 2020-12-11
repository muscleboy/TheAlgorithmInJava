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

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: 208
 * @createTime 2020-12-11 09:10
 */
// 208
public class Trie {

    // 是否某个单词的结束
    private boolean isWord = false;
    private Trie[] next = new Trie[26];

    public Trie() {

    }

    // 思路
    //   insert: 遍历 word，不存在，则创建新的节点；存在，则把该字符所在节点指向当前节点；遍历结束，标记可以形成单词
    //   search: 遍历 word，不存在，则返回 false 找不到；存在，则把该字符所在节点指向当前节点；遍历结束，返回标记
    //   searchWith: 遍历 word，遍历 word，不存在，则返回 false 找不到；存在，则把该字符所在节点指向当前节点；最后返回 true
    // 复杂度
    //   时间：都是O(n)，n 为字符串的长度
    //   空间：O(26*n)
    public void insert(String word) {
        Trie cur = this;
        for(char c : word.toCharArray()){
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Trie();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for(char c : word.toCharArray()){
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(char c : prefix.toCharArray()){
            if (cur.next[c - 'a'] == null){
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return true;
    }

}
