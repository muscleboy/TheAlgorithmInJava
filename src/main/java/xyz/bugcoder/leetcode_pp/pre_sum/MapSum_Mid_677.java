package xyz.bugcoder.leetcode_pp.pre_sum;

//实现一个 MapSum 类，支持两个方法，insert 和 sum：
//
//
// MapSum() 初始化 MapSum 对象
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 ke
//y 已经存在，那么原来的键值对将被替代成新的键值对。
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
//
//
//
//
// 示例：
//
//
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
//
//
//
//
// 提示：
//
//
// 1 <= key.length, prefix.length <= 50
// key 和 prefix 仅由小写英文字母组成
// 1 <= val <= 1000
// 最多调用 50 次 insert 和 sum
//
// Related Topics 字典树
// 👍 76 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.pre_sum
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-15 11:09
 */

/**
 * 思路
 *   构建一颗前缀树，还需要 val 字段；insert 操作都一样；sum 的话，不存在直接返回 0，存在的话，递归向下找，val 累加
 * 复杂度
 *   时间：O(N)，N 为单词的长度
 *   空间：O(M * N * K), M 为单次数量，N 为单词长度，K 为每个单词都不一样，K 最大为26
 */
public class MapSum_Mid_677 {

    class TrieNode{
        HashMap<Character, TrieNode> next = new HashMap<>();
        int value;
    }

    TrieNode root;

    public MapSum_Mid_677() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        for(char c : key.toCharArray()){
            if (!cur.next.containsKey(c)) {
                TrieNode temp = new TrieNode();
                cur.next.put(c, temp);
                cur = temp;
            }else {
                cur = cur.next.get(c);
            }
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            if (!cur.next.containsKey(c)){
                return 0;
            }
            cur = cur.next.get(c);
        }

        return getSum(cur);
    }

    // insert("apple", 3)
    // insert("app", 2)
    // 递归向下寻找，比如查找的是 "app", 那么 "apple"一定是"app"的下边
    // 所以递归向下找， 秒啊
    public int getSum(TrieNode root){
        int sum = root.value;
        for (char c : root.next.keySet()) {
            sum += getSum(root.next.get(c));
        }

        return sum;
    }

    public static void main(String[] args) {
        MapSum_Mid_677 m = new MapSum_Mid_677();
        m.insert("apple", 3);
        m.insert("app", 2);
        System.out.println(m.sum("app"));
        int[] res = {1,23,4};
        List<Integer> list = Arrays.asList(1,2,3,4);
        int[] ints = list.stream().mapToInt(i -> i).toArray();

    }

}
