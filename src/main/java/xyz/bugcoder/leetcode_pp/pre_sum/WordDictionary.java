package xyz.bugcoder.leetcode_pp.pre_sum;

//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
// 实现词典类 WordDictionary ：
//
//
// WordDictionary() 初始化词典对象
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。
//
//
//
//
// 示例：
//
//
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 500
// addWord 中的 word 由小写英文字母组成
// search 中的 word 由 '.' 或小写英文字母组成
// 最调用多 50000 次 addWord 和 search
//
// Related Topics 设计 字典树 回溯算法
// 👍 188 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-11 10:08
 */

// 211
public class WordDictionary {

    private WordDictionary[] next = new WordDictionary[26];
    private boolean isWord = false;

    public WordDictionary() {

    }

    // 思路
    //   addWord前缀树无差，search 的时候，遇到'.'，递归该节点的每一个分支，只要有一个分支返回 true，就说明找到一条；
    //   全部分支都没返回 true，说明没找到
    // 复杂度
    //   时间：O(N)，N 为字符串的长度
    //   空间：O(N)
    public void addWord(String word) {
        WordDictionary cur = this;
        for (char c : word.toCharArray()){
            if (cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new WordDictionary();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        WordDictionary cur = this;
        return match(word, cur, 0);
    }

    public boolean match(String word, WordDictionary node, int start){
        if (start == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(start);
        // 遇到'.'，递归该节点的每一个分支，只要有一个分支返回 true，就说明找到一条；全部分支都没返回 true，说明没找到
        if (c == '.'){
            for (int i = 0; i < 26; i++) {
                if (node.next[i] != null && match(word, node.next[i], start + 1)){
                    return true;
                }
            }
            return false;
        }else {
            if (node.next[c - 'a'] == null){
                return false;
            }
            return match(word, node.next[c - 'a'], start + 1);
        }
    }

}
